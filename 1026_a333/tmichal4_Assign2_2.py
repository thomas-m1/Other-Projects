#own vanilla investment strategy


def main():
    from investment_machine import InvestmentMachine
    import numpy as np

    for i in range(1000): # repeats code 1000 times

     my_investment_machines = InvestmentMachine()
     total_reward_machine_1 = 0
     total_reward_machine_2 = 0
     overall_reward = 0
     reward_list = []
     reward_list1 = []
     reward_list2 = []

     #tests each machine 10 times
     for times_machine_1 in range(20):
         total_reward_machine_1 = total_reward_machine_1 + my_investment_machines.invest(1, 1)-1
         reward_list1.append(total_reward_machine_1)


    #finds total profi/loss, calculates total amount and cuts in half to invest
     total_reward = total_reward_machine_1 + total_reward_machine_2
     invest = (100 + total_reward)

    #picks machine with greater profit
     if total_reward_machine_1 > 0:
         for times_machine_1 in range(10):
             overall_reward += my_investment_machines.invest(1, invest)
             overall_reward = overall_reward - invest
     else:
         for times_machine_2 in range(10):
             overall_reward += my_investment_machines.invest(1, invest)
             overall_reward = overall_reward - invest

     reward_list.append(overall_reward)#creates list

     rewardstotal = reward_list2 + reward_list1 + reward_list


    #calcultates average profit after 1000 trials
    average_profit = sum(rewardstotal) / len(rewardstotal)
    print("the average return each time you invest is: ", average_profit)

    #calculated standard deviation
    sd = np.std(rewardstotal)
    print("the standard deviation is: ", sd)

    #calculates sharpe ratio
    sr = average_profit / (sd + 1)
    print("the sharpe ratio is: ", sr)


main()
