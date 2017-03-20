package arrayList;

import java.util.Arrays;

public class ArrayUtil {
/**
 *����һ����������a���Ը������ֵ�����û�
 *���磺a=��7,9,30,3�����û���Ϊ��3,30,9,7��	
 * @param origin
 * @return
 */
	public static void reverseArray(int[] origin)
	{
		for(int i=0;i<origin.length/2;i++)
		{
			int temp=origin[i];
			origin[i]=origin[origin.length-i-1];
			origin[origin.length-i-1]=temp;
		}
	}
	
/**
 * ���������µ�һ�����飺 int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}
 * Ҫ������������ֵΪ0����ȥ��������Ϊ0��ֵ����һ�������顣���ɵ�����Ϊ��{1,3,4,5,6,6,5,4,7,6,7,5}
 * @param oldArray
 * @return
 */
	public static int[] removeZero(int[] oldArray)
	{
		int[] newArr=new int[oldArray.length];
		int c=0;
		for(int i=0,k=0;i<oldArray.length;i++)
		{
			if(oldArray[i]==0)
			{
				c++;
				continue;
			}
				
			else
			{
				newArr[k]=oldArray[i];
				k++;
			}
		}
		newArr=Arrays.copyOf(newArr, oldArray.length-c);
		return newArr;
	}

/**
 * ���������Ѿ�����õ��������飬a1��a2������һ���µ�����a3��ʹ��a3����a1��a2������Ԫ�أ�������Ȼ�������
 * ���� a1=��3,5,7,8�� a2=��4,5,6,7�� ��a3=��3,4,5,6,7,8�� ע�⣺�����ظ�
 * @param array1
 * @param array2
 * @return
 */
	public static int[] merge(int[] a, int[] b)
	{
	
		int n;
		int[] c=new int[a.length+b.length];
		int i=0,j=0,k=0,p=0,m=0;
		for(;k<a.length+b.length;k++)
		{			
			if(a[i]>b[j])
			{
				c[k]=b[j];
				j++;
			}
			else if(a[i]<b[j])
			{
				c[k]=a[i];
				i++;
			}
			else 
			{
				c[k]=a[i];
				i++;j++;m++;
			}
			
			if(b.length==j)
			{
				p=1;
				break;
			}
			else if(a.length==i)
			{
				p=0;
				break;
			}			
		}
		if(p==0)
		{
			System.arraycopy(b, j, c, k+1, b.length-j);
		}
		else 
		{
			System.arraycopy(a, i, c, k+1, b.length-i);
		}
		c=Arrays.copyOf(c, c.length-m);
		return c;
	}
	
	/**
	 * ��һ���Ѿ��������ݵ�����oldArray������������չ����չ��������ݴ�СΪoldArray��length+size
	 * ע�⣬�������Ԫ��������������Ҫ����
	 * ���� oldArray=[2,3,6],size=3,�򷵻ص�������Ϊ
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	
	public static int[] grow(int[] oldArray, int size)
	{
		int[] arr=new int[oldArray.length+size];
		arr=Arrays.copyOf(oldArray, oldArray.length+size);
		return arr;
	}
	
	/**
	 * 쳲��������У�1,1,2,3,5,8,13,21....������һ�����ֵ������С�ڸ�ֵ������
	 * ���磺max=15���򷵻ص�����Ӧ��Ϊ{1,1,2,3,5,8,13}
	 * max=1,���ؿ�����
	 * @param max
	 * @return
	 */
	
	public static int[] fibonacci(int max)
	{
		
		int[] arr=new int[]{};
		if(max==1)return arr;
		arr=grow(arr,2);
		arr[0]=arr[1]=1;
		int x=arr[0]+arr[1],i=2;
		while(x<max)
		{
			arr=grow(arr,1);
			arr[i]=x;
			i++;
			x=arr[i-1]+arr[i-2];
		}
		return arr;
	}
	
	/**
	 * ����С�ڸ������ֵmax��������������
	 * ���� max=23�����ص�����Ϊ[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	
	public static int[]getPrime(int max)
	{
		int[] arr=new int[]{2};
		int c=1;
		for(int i=3;i<max;i++)
		{
			int k=0;
			for(int j=2;j<i;j++)
			{
				if(i % j==0)
				{
					k=1;
					break;
				}
			}
			if(k==0)
			{
				arr=grow(arr,1);
				arr[c]=i;
				c++;
			}
		}
		return arr;
	}
	
	/**
	 * �����������ǡ�õ�����������֮�ͣ�����6=1+2+3��
	 * ����һ�����ֵmax������һ�����飬��������С��max����������
	 * @param max
	 * @return
	 */
	
	public static int[] getPerfectNumbers(int max)
	{
		int[] arr=new int[]{};
		int[] b=new int[]{};
		int c=0;
		for(int i=2;i<max;i++)
		{
			int k=0;
			for(int j=1;j<i;j++)
			{
				if(i%j==0)
				{
					b=grow(b,1);
					b[k]=j;
					k++;
				}
			}
			int sum=0;
			for(int j=0;j<k;j++)
			{				
				sum=sum+b[j];
			}
			if(sum==i)
			{
				arr=grow(arr,1);
				arr[c]=i;
				c++;
			}
		}
		return arr;
	}
	
	/**
	 * �� separator������array��������
	 * ����array=[3,8,9],separator="-";
	 * �򷵻�ֵ��"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	
	public static String join(int[] array,String separator)
	{
		String str = "";
		for(int i=0;i<array.length;i++)
		{
			str = str + array[i] + separator;
		}
		//  2-4-6-8
		str = str.substring(0,str.length()-1);
		return str;
	}
	
	public static int linearSearch(int[] origin,int x)
	{
		for(int i=0;i<origin.length;i++)
		{
			if(origin[i]==x)
				return i;
		}
		return -1;
	}
	
	public static int binarySearch(int[] origin,int x)
	{
		int a=0;
		int b=origin.length-1;
		int i;
		while(b-a>0)
		{
			i=(int)((b+a)/2);
			if(x==origin[i])
				return x;
			else if(x>origin[i])
				a=i;
			else b=i;
		}
		return -1;
	}
	
	public  static int[] bubbleSort(int[] arr)
	{
		int[] a=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			a[i]=arr[i];
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a;
	}
	
	public static int[] disorder(int[] arr)
	{
		int[] b=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			if(i>0)
			{
				for(int j=0;j<i;j++)
				{
					b[i]=(int)(arr.length*Math.random());
					if(b[j]==b[i])
					{
						j=-1;
						continue;
					}		
				}
			}
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(b[i]!=i)
			{
				int temp=arr[i];
				arr[i]=arr[b[i]];
				arr[b[i]]=temp;
			}
			else continue;
		}
		return arr;
	}
	
	public static int[] fill(int[] arr, int x)
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=x;
		}
		return arr;
	}
	
	public static int[][] fill(int[][] arr, int x)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
				arr[i][j]=x;
		}
		return arr;
	}
	
	
	
	
	
	
	
	
}
