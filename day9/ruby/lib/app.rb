require "set"

class App

    def num_tail_positions filename
        @tail = Knot.new
        @head = Head.new(@tail)
        lines = File.open(filename)
            .readlines
            .map(&:chomp)
            .map { |line| invoke_cmd cmd(line), rep(line) }
            
        @tail.positions.count
    end

    def invoke_cmd cmd, rep
        @head.send(cmd.downcase, rep.to_i)
    end

    def cmd(line)
        line.split[0]
    end
    def rep(line)
        line.split[1]
    end
end

class Head 
    def initialize(knot)
        @knot = knot
        @x = 0
        @y = 0
    end

    def r(times = 1)
        move(1, 0, times)
    end
    def l(times = 1)
        move(-1, 0, times)
    end
    def u(times = 1)
        move(0, 1, times)
    end
    def d(times = 1)
        move(0, -1, times)
    end

    def move(dx, dy, times = 1)
        times.times { |i| @knot.update_position(@x+=dx, @y+=dy) }
        position
    end

    def position
        [@x, @y]
    end
end

class Knot

    def initialize
        @x = 0
        @y = 0
        @positions = Set[[@x, @y]]
    end

    def update_position(hx, hy)
        if (hx - @x).abs > 1 
            @x += (hx - @x) / (hx - @x).abs

            if (hy - @y).abs == 1
                @y += (hy - @y) / (hy - @y).abs
            end
        end

        if (hy - @y).abs > 1
            @y += (hy - @y) / (hy - @y).abs
        
            if (hx - @x).abs == 1 
                @x += (hx - @x) / (hx - @x).abs
            end
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