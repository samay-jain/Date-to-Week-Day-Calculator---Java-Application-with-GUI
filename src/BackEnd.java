
public class BackEnd {
	public int convert(int lasttwo,int day,int month,boolean isleap,int addon)
	{
		int result=-1,step1,step2,step3,step4,jan=3,feb=0,march=3,april=2,may=3,jul=13,aug=16,sept=19,oct=21,nov=24,dec=26;
		if(lasttwo==0)
		{
			step1=99;
			step2=99/4;
		}
		else
		{
			step1 = lasttwo-1;
			step2 = (lasttwo-1)/4;
		}
		step3=0;
		if(isleap)
		{
			feb=1;

			jul=14;
			aug=17;
			sept=20;
			oct=22;
			nov=25;
			dec=27;
		}
		if(month==1)
			step3=day;
		else if(month==2)
			step3=day+jan;
		else if(month==3)
			step3=day+jan+feb;
		else if(month==4)
			step3=day+jan+feb+march;
		else if(month==5)
			step3=day+jan+feb+march+april;
		else if(month==6)
			step3=day+jan+feb+march+april+may;
		else if(month==7)
			step3=day+jul;
		else if(month==8)
			step3=day+aug;
		else if(month==9)
			step3=day+sept;
		else if(month==10)
			step3=day+oct;
		else if(month==11)
			step3=day+nov;
		else if(month==12)
			step3=day+dec;
		
		step4=step1+step2+step3+addon;
		result=step4%7;
		System.out.println(step1+" "+step2+" "+step3+" "+step4+" "+addon);
		return result;
	}
}
