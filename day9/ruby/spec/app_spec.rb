require "app"

describe App do
  before do
    @app = App.new
  end

  describe ".num_tail_positions" do
    context "given a file with moves" do
      it "counts the number of tail position visited at least once" do
        expect(@app.num_tail_positions("test.txt")).to eq(13)
      end
    end
  end

  describe Head do
    before do
      @head = Head.new(Tail.new)
    end

    context "when head goes to the right" do
      it "moves on the grid" do
        expect(@head.r).to eq([1, 0])
      end
    end
    context "when head goes to the left" do
      it "moves on the grid" do
        expect(@head.l).to eq([-1, 0])
      end
    end
    context "when head goes to the up" do
      it "moves on the grid" do
        expect(@head.u).to eq([0, 1])
      end
    end
    context "when head goes to the down" do
      it "moves on the grid" do
        expect(@head.d).to eq([0, -1])
      end
    end
  end

  describe Tail do
    before do
      @tail = Tail.new
      @head = Head.new(@tail)
    end

    context "when head moves, tails" do
      it "stays still if is not more than one move away" do
        @head.r
        expect(@tail.position).to eq([0, 0])
      end
      it "moves when head is two block far away" do
        @head.r
        @head.r
        @head.r
        expect(@tail.position).to eq([2, 0])
      end
      it "moves when head is two block far away" do
        @head.l
        @head.l
        @head.l
        expect(@tail.position).to eq([-2, 0])
      end
      it "moves when head is two block far away" do
        @head.u
        @head.u
        @head.u
        expect(@tail.position).to eq([0, 2])
      end
      it "moves when head is two block far away" do
        @head.d
        @head.d
        @head.d
        expect(@tail.position).to eq([0, -2])
      end
      it "moves when head is two block far away" do
        @head.u
        @head.r
        @head.u
        expect(@head.position).to eq([1, 2])
      end
      it "moves when head is two block far away" do
        @head.u
        @head.r
        @head.r
        expect(@head.position).to eq([2, 1])
        expect(@tail.position).to eq([1, 1])
      end
      it "moves when head is two block far away" do
        @head.u
        @head.r
        @head.r
        expect(@head.position).to eq([2, 1])
        expect(@tail.position).to eq([1, 1])
      end
      it "records the position of the tail" do
        @head.u
        @head.r
        @head.r
        @head.r
        expect(@tail.position).to eq([2, 1])
        expect(@tail.positions).to eq(Set[[0,0],[1,1],[2,1]])
      end
    end
  end
end
