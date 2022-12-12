require "set"

class App

    def num_tail_positions filename
        @tail = Tail.new
        @head = Head.new(@tail)
        lines = File.open(filename).readlines.map(&:chomp)
        lines.map do |line|
            cmd = line.split[0]
            rep = line.split[1].to_i
            rep.times do |n|
                if cmd == 'R' 
                    @head.r
                end
                if cmd == 'L' 
                    @head.l
                end
                if cmd == 'U' 
                    @head.u
                end
                if cmd == 'D' 
                    @head.d
                end
            end
        end
        @tail.positions.count
    end
end

class Head 
    def initialize(tail)
        @tail = tail
        @x = 0
        @y = 0
    end

    def r
        @tail.update_head_position(@x+=1, @y)
        position
    end
    def l
        @tail.update_head_position(@x-=1, @y)
        position
    end
    def u
        @tail.update_head_position(@x, @y+=1)
        position
    end
    def d
        @tail.update_head_position(@x, @y-=1)
        position
    end

    def position
        [@x, @y]
    end
end

class Tail

    def initialize
        @x = 0
        @y = 0
        @positions = Set.new
    end

    # 1..H.   H(2,1) x=2-0 = 2
    # 0T...   T(0,0) y=1-0 = 1
    #  0123
    #
    # 1T.H.   H(2,1) x=2-0 = 2
    # 0....   T(0,1) y=1-1 = 0
    #  0123
    #
    def update_head_position(hx, hy)
        if (hx - @x).abs > 1 && (hy - @y) == 0
            @x += (hx - @x) / (hx - @x).abs
        end
        if (hx - @x) == 0 && (hy - @y).abs > 1
            @y += (hy - @y) / (hy - @y).abs
        end
        if (hx - @x).abs > 1 && (hy - @y).abs == 1
            @x += (hx - @x) / (hx - @x).abs
            @y += hy - @y
        end
        if (hx - @x).abs == 1 && (hy - @y).abs > 1
            @x += hx - @x
            @y += (hy - @y) / (hy - @y).abs
        end
        record position
        position
    end

    def record position
        positions.add position
    end

    def positions
        @positions
    end

    def position
        [@x, @y]
    end
end

puts App.new.num_tail_positions "input.txt"