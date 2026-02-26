import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Installment_Purchase{
    static double find_rate(double  cost, int num_month, double  pay_now, double pay_eachMonth) {
        double rate = 0;
        for (int i = 0; i < 10; i++) {
            rate += 0.1;
            if ((cost - pay_now) * rate / (1 - Math.pow(1 + rate, -num_month)) > pay_eachMonth) {
                rate -= 0.1;
                for (int j = 0; j < 10; j++) {
                    rate += 0.01;
                    if ((cost - pay_now) * rate / (1 - Math.pow(1 + rate, -num_month)) > pay_eachMonth) {
                        rate -= 0.01;
                        for (int k = 0; k < 10; k++) {
                            rate += 0.001;
                            if ((cost - pay_now) * rate / (1 - Math.pow(1 + rate, -num_month)) >= pay_eachMonth) {
                                double KQ1 = (cost - pay_now) * rate / (1 - Math.pow(1 + rate, -num_month)) - pay_eachMonth;
                                double rate2 = rate - 0.001;
                                double KQ2 = pay_eachMonth - (cost - pay_now) * rate2 / (1 - Math.pow(1 + rate2, -num_month));
                                if (KQ2 < KQ1) {
                                    rate = rate2;
                                }
                                return rate;
                            }
                        }
                    }
                }
            }
        }
        return rate;
    }
	public static void main(String[] args) {
        double cost = nd();
        int num_month = ni();
        double pay_now = nd();
        double pay_eachMonth = nd();
        double rate = find_rate(cost, num_month, pay_now, pay_eachMonth);
        System.out.printf("%.3f", rate);
    
}
	

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
