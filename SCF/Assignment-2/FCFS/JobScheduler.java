import java.io.IOException;

/**
 * JobScheduler class used for First Come First Serve job scheduling it contain methods
 *  to calculate waiting time, completion time, turn around time,average waiting time, etc
 */

public class JobScheduler 
{
	/**
	 * @param process take a two dimension array containing arrival time and burst time of process         
	 * @param numberOfProcess take number of process saved in one dimension array          
	 * @return a sorted two dimension array sorted as per the arrival time of each process
	 */
	
	public boolean inputValidation(int process[][], int numberOfProcess)
	{
		if(numberOfProcess >= 0)
		{
			for(int i=0; i< numberOfProcess; i++)
			{
				int processArrivalTime = process[i][0];
				int processBurstTime = process[i][1];
	
				if(processArrivalTime < 0 && processBurstTime < 1)
				{
					return false;
				}
			}	
		}
		else 
			return false;
		
		return true;
	}
	
	/**
	 * @param process take a two dimension array containing arrival time and burst time of process         
	 * @param numberOfProcess take number of process saved in one dimension array          
	 * @return a sorted two dimension array sorted as per the arrival time of each process
	 */
	
	public int[][] sortProcess(int process[][], int numberOfProcess) throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int tempProcessArrivalTime;
		int tempProcessBurstTime;
		int sortedProcess[][] = process;

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			int firstProcessArrivalTime = sortedProcess[firstIndex][0];
			int firstProcessBurstTime = sortedProcess[firstIndex][1];

			for (int secondIndex = firstIndex + 1; secondIndex < numberOfProcess; secondIndex++) 
			{
				int secondProcessArrivalTime = sortedProcess[secondIndex][0];
				int secondProcessBurstTime = sortedProcess[secondIndex][1];

				if (firstProcessArrivalTime > secondProcessArrivalTime) 
				{
					tempProcessArrivalTime = secondProcessArrivalTime;
					tempProcessBurstTime = secondProcessBurstTime;

					sortedProcess[secondIndex][0] = firstProcessArrivalTime;
					sortedProcess[secondIndex][1] = firstProcessBurstTime;
					
					sortedProcess[firstIndex][0] = tempProcessArrivalTime;
					sortedProcess[firstIndex][1] = tempProcessBurstTime;
				}
			}
		}
		return sortedProcess;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process  
	 * @param numberOfProcess take number of process saved in one dimension array   
	 * @return an one dimension array which contain completion time for all process
	 */
	
	public int[] getCompletionTime(int process[][], int numberOfProcess) throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int completionTime[] = new int[numberOfProcess];
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			int processArrivalTime = sortedProcess[firstIndex][0];
			int processBurstTime = sortedProcess[firstIndex][1];
			
			if (firstIndex == 0) 
			{
				completionTime[firstIndex] = processArrivalTime + processBurstTime;
				continue;
			}
			int completionTimeOfPreviousProcess = completionTime[firstIndex - 1];
			
			int gap=0;
			if(processArrivalTime > completionTimeOfPreviousProcess)
				gap = processArrivalTime - completionTimeOfPreviousProcess;
			
			completionTime[firstIndex] = completionTimeOfPreviousProcess + processBurstTime +gap;
		}
		return completionTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process saved in one dimension array
	 * @return an one dimension array which contain turn around time for all process
	 */
	
	public int[] getTurnAroundTime(int process[][], int numberOfProcess) throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int turnAroundTime[] = new int[numberOfProcess];
		int sortedProcess[][] = sortProcess(process, numberOfProcess);
		int completionTime[] = getCompletionTime(sortedProcess, numberOfProcess);

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			int completionTimeOfProcess = completionTime[firstIndex];
			int arrivalTimeOfProcess = sortedProcess[firstIndex][0];

			turnAroundTime[firstIndex] = completionTimeOfProcess - arrivalTimeOfProcess;
		}
		return turnAroundTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process saved in one dimension array
	 * @return an one dimension array which contain waiting time for all process
	 */
	
	public int[] getWaitingTime(int process[][], int numberOfProcess) throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int waitingTime[] = new int[numberOfProcess];

		int sortedProcess[][] = sortProcess(process, numberOfProcess);
		int turnAroundTime[] = getTurnAroundTime(sortedProcess, numberOfProcess);

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			if (firstIndex == 0) 
			{
				waitingTime[firstIndex] = 0;
			} 
			
			else 
			{
				int turnAroundtimeOfProcess = turnAroundTime[firstIndex];
				int burstTimeOfProcess = sortedProcess[firstIndex][1];

				waitingTime[firstIndex] = turnAroundtimeOfProcess - burstTimeOfProcess;
			}
		}
		return waitingTime;
	}
	
	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process saved in one dimension array
	 * @return an double which contain average waiting time for process
	 */
	
	public double getAvrageWaitingTime(int process[][], int numberOfProcess)  throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int avrageWaitingTime = 0;
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		int waitingTime[] = getWaitingTime(sortedProcess, numberOfProcess);
		int totalWaitTime = 0;

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			totalWaitTime += waitingTime[firstIndex];
		}

		avrageWaitingTime = totalWaitTime / numberOfProcess;
		return avrageWaitingTime;
	}

	/**
	 * @param process take two dimension array which contain arrival time and burst time of n process
	 * @param numberOfProcess take number of process saved in one dimension array
	 * @return an integer which contain maximum waiting time for process
	 */
	
	public int getMaximumWaitingTime(int process[][], int numberOfProcess) throws IOException
	{
		boolean validInput = inputValidation(process, numberOfProcess);
		if(validInput == false)
		{
			throw new IOException("Invalid Inputs !!!!!!");
		}
		
		int maximumWaitingTime = 0;
		int sortedProcess[][] = sortProcess(process, numberOfProcess);

		int waitingTime[] = getWaitingTime(sortedProcess, numberOfProcess);
		maximumWaitingTime = waitingTime[0];

		for (int firstIndex = 0; firstIndex < numberOfProcess; firstIndex++) 
		{
			if (maximumWaitingTime < waitingTime[firstIndex]) 
			{
				maximumWaitingTime = waitingTime[firstIndex];
			}
		}

		return maximumWaitingTime;
	}
}