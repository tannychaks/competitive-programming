package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

class FastScanner {
 private BufferedReader reader;
 private StringTokenizer tokenizer;

 public FastScanner(InputStream inputStream) {
  reader = new BufferedReader(new InputStreamReader(inputStream));
 }

 public String next() throws IOException {
  while (tokenizer == null || !tokenizer.hasMoreTokens()) {
   String line = reader.readLine();
   if (line == null)
    throw new IOException();
   tokenizer = new StringTokenizer(line);
  }
  return tokenizer.nextToken();
 }

 public int nextInt() throws IOException {
  return Integer.parseInt(next());
 }

 public long nextLong() throws IOException {
  return Long.parseLong(next());
 }

 public BigInteger nextBigInteger() throws IOException {
  return new BigInteger(next());
 }

 public void close() {
  try {
   reader.close();
  } catch (IOException e) {
   // ignore
  }
 }
}

public class StackOperations {
 public static void main(String[] args) throws IOException {
  FastScanner sc = new FastScanner(System.in);
  int N = sc.nextInt();
  int K = sc.nextInt();
  Long[] arr = new Long[N];
  Long largestElement = 0L;
  for (int i = 0; i < N; i++) {
   arr[i] = sc.nextLong();
   largestElement = Math.max(largestElement, arr[i]);
  }
  if (N == 1 && ((K & 1) == 1)) {
   System.out.println(-1);
   sc.close();
   return;
  }

  if (K <= N) {
   Stack<Long> stack = new Stack<>();
   long maxValue = 0L;
   for (int i = (N - 1); i >= 0; i--)
    stack.push(arr[i]);
   if (K == 1) {
    System.out.println(arr[K]);
    sc.close();
    return;
   }
   for (int i = 0; i < (K - 1); i++) {
    long poppedElement = stack.pop();
    maxValue = Math.max(maxValue, poppedElement);
   }
   // stack.push(maxValue.max(arr[K - 1]));
   System.out.println(Math.max(maxValue, arr[K]));
  } else {
   System.out.println(largestElement);
  }
  // Arrays.stream(arr).max(BigInteger::compareTo).ifPresent(System.out::println);

  sc.close();
 }
}