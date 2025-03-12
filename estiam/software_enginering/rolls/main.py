import re
import random

def group_by_dice_size(values):
    groups = {}

    for value in values:
        match = re.match(r'(\d+)?d(\d+)', value)
        if match and match.groups()[1]:
            dice_size = int(match.group(2)) if match.group(2) else 'add'

            if dice_size in groups:
                groups[dice_size] += int(match.group(1))
            else:
                groups[dice_size] = int(match.group(1))
        else:
            if 'add' in groups:
                groups['add'] += int(value)
            else:
                groups['add'] = int(value)

    return groups

def roll_the_dices(groups):
    value = 0

    for dice_size, roll_times in groups.items():
        if dice_size == 'add':
            value += roll_times
            continue
        
        for _ in range(roll_times):
            value += random.randint(1, dice_size)
    
    return value
        

def main():
    values: str = str(input("Entrez la suite de dés : "))
    positive = [x for x in values.split('+') if '-' not in x]
    negative = [x for x in values.split('-') if '+' not in x]

    print(roll_the_dices(group_by_dice_size(positive)) - roll_the_dices(group_by_dice_size(negative)))


if __name__ == "__main__":
    main()