file = File.open("input.txt")
calories = file.readlines.map(&:chomp).map { |s| s.to_i }

carried_calories_by_elf = 0
list_of_carried_calories = []

calories.each do |calorie|
  if calorie == 0
    list_of_carried_calories << carried_calories_by_elf
    carried_calories_by_elf = 0
  end
  carried_calories_by_elf = carried_calories_by_elf + calorie
end

p list_of_carried_calories.max
