import java.util.Scanner;

public class TextJobScheduler 
{
	public static void main(String[] args) 
	{
		JobScheduler jobScheduler = new JobScheduler();

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter Number Of Process :");
		int numberOfProcess = userInput.nextInt();
				
		int process[][] = new int[numberOfProcess][2];

		for (int loop = 0; loop < numberOfProcess; loop++) 
		{
			System.out.print("Enter Arrival Time Of Process " + (loop + 1) + " : ");
			process[loop][0] = userInput.nextInt();
			System.out.print("Enter Burst Time Of Process " + (loop + 1) + " : ");
			process[loop][1] = userInput.nextInt();
		}

		while (true) 
		{
			System.out.println("\n1.Calculate Completion Time Of All Process");
			System.out.println("2.Calculate Waiting Time Of All Process");
			System.out.println("3.Calculate Turn Around Time Of All Process");
			System.out.println("4.Calculate Average Waiting Time");
			System.out.println("5.Calculate Maximum Waiting Time");
			System.out.println("6.Exit");
			System.out.println();

			int option = userInput.nextInt();

			if (option == 7) 
			{
				System.out.println("Thank You");
				break;
			}
			switch (option) 
			{
			case 1: 
			{
				try
				{
					int completionTime[] = jobScheduler.getCompletionTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) 
					{
						System.out.println("Completion Time Of Process " + (loop + 1) + " :\t" + completionTime[loop]);
					}
				}
				catch(Exception Ex)
				{
					System.out.println(Ex);
				}

				break;
			}
			case 2: 
			{
				try
				{
					int waitingTime[] = jobScheduler.getWaitingTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) 
					{
						System.out.println("Waiting Time Of Process " + (loop + 1) + " :\t" + waitingTime[loop]);
					}
				}
				catch(Exception Ex)
				{
					System.out.println(Ex);
				}

				break;
			}
			case 3: 
			{
				try
				{
					int turnAroundTime[] = jobScheduler.getTurnAroundTime(process, numberOfProcess);
					for (int loop = 0; loop < numberOfProcess; loop++) 
					{
						System.out.println("Turn Around Time Of Process " + (loop + 1) + " :\t" + turnAroundTime[loop]);
					}
				}
				catch(Exception Ex)
				{
					System.out.println(Ex);
				}
				break;
			}
			case 4: 
			{
				try
				{
					double avrageWaitingTime = jobScheduler.getAvrageWaitingTime(process, numberOfProcess);
					System.out.println("Avrage Waiting Time Of Process is :\t" + avrageWaitingTime);
				}
				catch(Exception Ex)
				{
					System.out.println(Ex);
				}
				break;
			}
			case 5: 
			{
				try
				{
					int maximumWaitingTime = jobScheduler.getMaximumWaitingTime(process, numberOfProcess);
					System.out.println("Maximum Waiting Time Of Process is :\t" + maximumWaitingTime);
				}
				catch(Exception Ex)
				{
					System.out.println(Ex);
				}
				break;
			}
			case 6: 
			{
				System.exit(0);
				break;
			}

			default: 
			{
				System.out.println("Invalid Choice !!!!!");
			}
			}
		}

	}

}