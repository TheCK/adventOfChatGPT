# Part 1

To find the Elf carrying the most Calories, we can start by reading the input and storing the Calories for each Elf in a
list. Then, we can iterate through the list of Calories and keep track of the maximum Calories and the Elf who is
carrying them. Finally, we can print the total number of Calories carried by the Elf with the maximum Calories.

Here is some example Python code that implements this solution:

```
# Read the input and store the Calories for each Elf in a list
calories = []
current_elf = []

for line in input():
# If the line is blank, we have reached the end of the current Elf's inventory
if line.strip() == "":
# Add the current Elf's Calories to the list and reset the current Elf's inventory
calories.append(sum(current_elf))
current_elf = []
else:
# Add the current food item's Calories to the current Elf's inventory
current_elf.append(int(line))

# Add the last Elf's Calories to the list
calories.append(sum(current_elf))

# Find the Elf carrying the most Calories
max_calories = 0
max_elf = -1

for i, c in enumerate(calories):
if c > max_calories:
max_calories = c
max_elf = i

# Print the total number of Calories carried by the Elf with the maximum Calories
print(max_calories)
```

Note that this code is just an example and may not work if pasted directly into a Python interpreter, as it does not
include necessary imports or handle edge cases such as empty input.

Here is a Java solution that implements the steps described above:

```
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Read the input and store the Calories for each Elf in a list
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> calories = new ArrayList<>();
        ArrayList<Integer> currentElf = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("")) {
                // Add the current Elf's Calories to the list and reset the current Elf's inventory
                calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());
                currentElf.clear();
            } else {
                // Add the current food item's Calories to the current Elf's inventory
                currentElf.add(Integer.parseInt(line));
            }
        }

        // Add the last Elf's Calories to the list
        calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());

        // Find the Elf carrying the most Calories
        int maxCalories = 0;
        int maxElf = -1;

        for (int i = 0; i < calories.size(); i++) {
            int c = calories.get(i);
            if (c > maxCalories) {
                maxCalories = c;
                maxElf = i;
            }
        }

        // Print the total number of Calories carried by the Elf with the maximum Calories
        System.out.println(maxCalories);
    }
}
```

Note that this code is just an example and may not work if pasted directly into a Java compiler, as it does not include
necessary imports or handle edge cases such as empty input.

# Part 2

To find the top three Elves carrying the most Calories, we can modify the solution above by sorting the list of Calories
in descending order and then adding up the Calories carried by the first three Elves in the sorted list.

Here is an example Python solution that implements this approach:

```
# Read the input and store the Calories for each Elf in a list

calories = []
current_elf = []

for line in input():

# If the line is blank, we have reached the end of the current Elf's inventory

if line.strip() == "":

# Add the current Elf's Calories to the list and reset the current Elf's inventory

calories.append(sum(current_elf))
current_elf = []
else:

# Add the current food item's Calories to the current Elf's inventory

current_elf.append(int(line))

# Add the last Elf's Calories to the list

calories.append(sum(current_elf))

# Sort the Calories in descending order

calories.sort(reverse=True)

# Add up the Calories carried by the top three Elves

top_three_calories = sum(calories[:3])

# Print the total number of Calories carried by the top three Elves

print(top_three_calories)
```

Note that this code is just an example and may not work if pasted directly into a Python interpreter, as it does not
include necessary imports or handle edge cases such as empty input or less than three Elves.

Here is the corresponding Java solution:

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Read the input and store the Calories for each Elf in a list
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> calories = new ArrayList<>();
        ArrayList<Integer> currentElf = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equals("")) {
                // Add the current Elf's Calories to the list and reset the current Elf's inventory
                calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());
                currentElf.clear();
            } else {
                // Add the current food item's Calories to the current Elf's inventory
                currentElf.add(Integer.parseInt(line));
            }
        }

        // Add the last Elf's Calories to the list
        calories.add(currentElf.stream().mapToInt(Integer::intValue).sum());

        // Sort the Calories in descending order
        Collections.sort(calories, Collections.reverseOrder());

        // Add up the Calories carried by the top three Elves
        int topThreeCalories = 0;
        for (int i = 0; i < 3 && i < calories.size(); i++) {
            topThreeCalories += calories.get(i);
        }

        // Print the total number of Calories carried by the top three Elves
        System.out.println(topThreeCalories);
    }

}
```

Note that this code is just an example and may not work if pasted directly into a Java compiler, as it does not include
necessary imports or handle