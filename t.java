	public static double[] shuffle(double[] a)
	{
	 int N = a.length;
	 for (int i = 0; i < N; i++)
	 { // Exchange a[i] with random element in a[i..N-1]
	 int r = i + random.nextInt(N-i);
	 double temp = a[i];
	 a[i] = a[r];
	 a[r] = temp;
	 }
	 
	 for (int i = 0; i < N; i++)
	 { // Exchange a[i] with random element in a[i..N-1]
		 System.out.println(a[i]);
	 }
	 return a;
	}