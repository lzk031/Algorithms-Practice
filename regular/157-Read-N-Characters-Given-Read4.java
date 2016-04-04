// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

// Note:
// The read function will only be called once for each test case.

// Show Tags
// Show Similar Problems

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int res = 0;
        char[] b = new char[4];
        int tmp = read4(b);
        for (int i=0; i<tmp; i++) {
            buf[res + i] = b[i];
        }
        res += tmp;
        while (res < n && tmp == 4) {
            tmp = read4(b);
            for (int i=0; res+i<n && i<tmp; i++) {
                buf[res+i] = b[i];
            }
            res += tmp;
        }
        if (res >= n) return n;
        return res;
    }
}