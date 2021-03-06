package net.dattas.nwsynthesis.control;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.math.*;

import net.dattas.nwsynthesis.databean.AffiliationDataBean;
import net.dattas.nwsynthesis.ioformat.*;
import net.dattas.nwsynthesis.util.*;

public class NetworkModelingController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		manualRun();
		
	}
	
	public static void manualRun()
	{
		int branch = 0; // branch of tree
		int height = 0; // height of tree
		int choice = 0;
		int lower = 0;
		int upper = 0;
		
		double lowerd = 0.0;
		double upperd = 0.0;
		
		int n = 0;
		int flag = 0;
		//double i = 0.0;
		int temp = 0;
		
		double p = 0.0; // probability of a link existing between the leaf nodes under a parent
		
		int peerLevel = 0; // level at which peer nodes will connect
		
		double q = 0.0; // probability of a link existing between peer nodes at given peerLevel
		
		double randAffProb = 0.0; // probability of random affiliations
		String temp1 = null;
		String temp2 = null;
		String temp3 = null;
		String temp4 = null;
		String temp5 = null;
		String temp6 = null;
		String l;
		String u;
		
		Scanner choiceScanner = new Scanner(System.in);
		
		
		System.out.print("Select the parameter which you want to vary over a range of values:");
		System.out.print("\n1.No of branches\n2.Height\n3.Probability of affiliation of leaf nodes under same parent\n4.Given level?\n5.Probability of affiliation at a given level\n6.Random affiliation probability\n");
		String a = choiceScanner.nextLine();
		choice = (new Integer(a)).intValue();
		
		switch(choice)
		{	
			case 1:
				System.out.print("\nYou have selected Branches\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lower = (new Integer(l)).intValue();
				}while(lower <= 0);
				
				do
				{
					System.out.println("\nEnter upper limit:");
					u = choiceScanner.nextLine();
					upper = (new Integer(u)).intValue();
				}while(upper <= 0 || upper < lower);
				
				//n = upper - lower;
				temp1 = l;
				flag = 1;
				temp = 1;       // 1 for branches
				break;
			case 2:
				System.out.print("\nYou have selected Height\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lower = (new Integer(l)).intValue();
				}while(lower <= 0);
				
				do
				{
					System.out.println("\nEnter upper limit:");
					u = choiceScanner.nextLine();
					upper = (new Integer(u)).intValue();
				}while(upper <= 0 || upper < lower);
				
				//n = upper - lower;
				temp2 = l;
				flag = 1;
				temp = 2;     // 2 for height
				break;
			case 3:
				System.out.print("\nYou have selected Probability of affiliation\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lowerd = (new Double(l)).doubleValue();
				}while(lowerd < 0 || lowerd > 1);
				
				do
				{
				System.out.println("\nEnter upper limit:");
				u = choiceScanner.nextLine();
				upperd = (new Double(u)).doubleValue();
				}while(upperd < 0 || upperd > 1 || upperd < lowerd);
				
				//n = upperd - lowerd;
				temp3 = l;
				flag = 1;
				temp = 3;     // 3 for probability of affiliation
				break;
			case 4:
				System.out.print("\nYou have selected Given Level\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lower = (new Integer(l)).intValue();
				}while(lower <= 0);
				
				do
				{
					System.out.println("\nEnter upper limit:");
					u = choiceScanner.nextLine();
					upper = (new Integer(u)).intValue();	
				}while(upper <= 0 || upper < lower);
				
				//n = upper - lower;
				temp4 = l;
				flag = 1;
				temp = 4;           // 4 for given level
				break;
			case 5:
				System.out.print("\nYou have selected Probability of affiliation at a given level\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lowerd = (new Double(l)).doubleValue();
				}while(lowerd < 0 || lowerd > 1);
				
				do
				{
					System.out.println("\nEnter upper limit:");
					u = choiceScanner.nextLine();
					upperd = (new Double(u)).doubleValue();
				}while(upperd < 0 || upperd > 1 || upperd < lowerd);
				
				//n = upperd - lowerd;
				temp5 = l;
				flag = 1;
				temp = 5;        // 5 for prob of affiliation at a given level
				break;
			case 6:
				System.out.print("\nYou have selected Random Affiliation\n");
				do
				{
					System.out.println("Enter lower limit:");
					l = choiceScanner.nextLine();
					lowerd = (new Double(l)).doubleValue();
				}while(lowerd < 0 || lowerd > 1);
				
				do
				{
					System.out.println("\nEnter upper limit:");
					u = choiceScanner.nextLine();
					upperd = (new Double(u)).doubleValue();
				}while(upperd < 0 || upperd > 1 || upperd < lowerd);
				//n = upperd - lowerd;
				temp6 = l;
				flag = 1;
				temp = 6;        // 6 for random affiliation
				break;
			default:
				break;
		}
		
		
		if(temp != 1)
		{
			do
			{
				System.out.print("No of branches? \n");
				temp1 = choiceScanner.nextLine();
				branch = (new Integer(temp1)).intValue();
			}while(branch <= 0);
		}
		
		if(temp != 2)
		{
			do
			{
				System.out.print("Height? \n");
				temp2 = choiceScanner.nextLine();
				height = (new Integer(temp2)).intValue();
			}while(height <= 0);
		}
		
		if(temp != 3)
		{
			do
			{
				System.out.println("Probability of affiliation of leaf nodes under same parent? \n");
				temp3 = choiceScanner.nextLine();
				p = (new Double(temp3)).doubleValue();
			}while(p<0 || p >1);
		}
		
		if(temp != 4)
		{
			do
			{
				System.out.println("Given level? \n");
				temp4 = choiceScanner.nextLine();
				peerLevel = (new Integer(temp4)).intValue();
			}while(peerLevel < 0);
		}
		
		if(temp != 5)
		{
			do
			{
				System.out.println("Probability of affiliation at a given level? \n");
				temp5 = choiceScanner.nextLine();
				q = (new Double(temp5)).doubleValue();
			}while(q<0 || q >1);
		}
		
		if(temp != 6)
		{
			do
			{
				System.out.println("Random affiliation probability?");
				temp6 = choiceScanner.nextLine();
				randAffProb = (new Double(temp6)).doubleValue();
			}while(randAffProb<0 || randAffProb >1);
		}
		
		// Start: Invoke modeler and print output
		while(lower <= upper && lowerd <= upperd)
		{
			if(temp == 1)
			{
				branch = lower;
			//	System.out.println("Value before netowrk:" + lower);
			}
			if(temp == 2)
			{
				height = lower;
				//System.out.println("Value before netowrk:" + lower);
			}
			if(temp == 3)
			{
				p = lowerd;
				//System.out.println("Value before netowrk:" + lowerd);
			}
			if(temp == 4)
			{
				peerLevel = lower;
				//System.out.println("Value before netowrk:" + lower);
			}
			if(temp == 5)
			{
				q = lowerd;
				//System.out.println("Value before netowrk:" + lowerd);
			}
			if(temp == 6)
			{
				randAffProb = lowerd;
				//System.out.println("Value before netowrk:" + lowerd);
			}
				
				
				
			ProbabilisticNetworkModeler bbm = new ProbabilisticNetworkModeler();
			PajekInputFormatter pif = new PajekInputFormatter();
				
			Vector<Vector<Integer>> levels = bbm.generateLevels(height, branch);
			
			Vector<String> vertexIDs = bbm.generateVertices(height,branch);
				
			Vector<AffiliationDataBean> affiliations = bbm.generateAffiliations(levels, branch, height, p, peerLevel, q, randAffProb, vertexIDs);
				
				
			String pajekFileName = pif.formatPajekInput(affiliations,vertexIDs, 0, "entity");
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter("Bridge_Building_Model_manual_output_v02.csv", true));
				
				out.write(temp1);
				out.write(",");
				out.write(temp2);
				out.write(",");
				out.write(temp3);
				out.write(",");
				out.write(temp4);
				out.write(",");
				out.write(temp5);
				out.write(",");
				out.write(temp6);
				out.write(",");
				out.write((new Integer(vertexIDs.size()).toString()));
				out.write(",");
				out.write((new Integer(affiliations.size())).toString());
				out.write(",");
				out.write(pajekFileName);
				out.write("\n");
				out.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	
					
			if(temp == 1 || temp == 2 || temp == 4)
			{
				lower++;
				//System.out.println("Value after netowrk:" + lower);
			}
			
			if(temp == 3 || temp == 5 || temp == 6)
			{
				lowerd = lowerd + 0.05;
				DecimalFormat df = new DecimalFormat("#.##");
				String s = df.format(lowerd);
				lowerd = (new Double(s)).doubleValue();
				
				//System.out.println("Value after netowrk:" + lowerd);
			}
			
		}	// End: Invoke modeler and print output
		
			choiceScanner.close();

	}
}
