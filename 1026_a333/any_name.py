#import Investment Machine class
from investment_machine import InvestmentMachine
# #initialize investment machine instance
# my_investment_machines = InvestmentMachine()
# total_reward_machine_1 = 0
# total_reward_machine_2 = 0
# #invest to machine 1 with $3 for 15 times
# for times_machine_1 in range(15):
#  # v1 += v2 is shorthand for v1 = v1 + v2
#  total_reward_machine_1 += my_investment_machines.invest(1, 3)
#  # The first argument is for machine 1 or machine 2, randomly assigned to have 40% and 60% return
#  # The second argument is for the amount of money put in.
# #invest to machine 2 with $3 for 15 times
# for times_machine_2 in range(15):
#  total_reward_machine_2 += my_investment_machines.invest(2, 3)
# print("The total return of my investment strategy is $", total_reward_machine_1 + total_reward_machine_2)

for i in range(1000): # repeats code 1000 times

 my_investment_machines = InvestmentMachine()
 total_reward_machine_1 = 0
 total_reward_machine_2 = 0
 overall_reward = 0
 reward_list = []

#tests each machine 10 times
 for times_machine_1 in range(10):
     total_reward_machine_1 = total_reward_machine_1 + my_investment_machines.invest(1, 1)-1
 for times_machine_2 in range(10):
     total_reward_machine_2 = total_reward_machine_2 + my_investment_machines.invest(2, 1)-1

#finds total profi/loss, calculates total amount and cuts in half to invest
 total_reward = total_reward_machine_1 + total_reward_machine_2
 invest = (100 + total_reward)/2

#picks machine with greater profit
 if total_reward_machine_1 > total_reward_machine_2:
     for times_machine_1 in range(10):
         overall_reward += my_investment_machines.invest(1, invest)
 else:
     for times_machine_2 in range(10):
         overall_reward += my_investment_machines.invest(1, invest)

 reward_list.append(overall_reward)#creates list

#calcultates average profit after 1000 trials
average_profit = sum(reward_list) / len(reward_list)
print(average_profit)

