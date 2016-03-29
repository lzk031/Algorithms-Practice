// An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

// For example, given the following image:

// [
//   "0010",
//   "0110",
//   "0100"
// ]
// and x = 0, y = 2,
// Return 6.

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        boolean row[] = new boolean[m];
        boolean col[] = new boolean[n];
        
        // find left
        int left = y;
        int start = 0;
        int end = y;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, row, col, 1, mid) && (mid==0 || !hasBlack(image, row, col, 1, mid-1))) {
                left = mid; break;
            }
            if (hasBlack(image, row, col, 1, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        // find right
        int right = y;
        start = y;
        end = n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, row, col, 1, mid) && (mid==n-1 || !hasBlack(image, row, col, 1, mid+1))) {
                right = mid; break;
            }
            if (hasBlack(image, row, col, 1, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        int top = x;
        start = 0;
        end = x;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, row, col, 0, mid) && (mid==0 || !hasBlack(image, row, col, 0, mid-1))) {
                top = mid; break;
            }
            if (hasBlack(image, row, col, 0, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        int bottom = x;
        start = x;
        end = m-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (hasBlack(image, row, col, 0, mid) && (mid==m-1 || !hasBlack(image, row, col, 0, mid+1))) {
                bottom = mid; break;
            }
            if (hasBlack(image, row, col, 0, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        int res = right - left + 1;
        res *= (bottom - top + 1);
        return res;
    }
    
    private boolean hasBlack(char[][] image, boolean[] row, boolean[] col, int direction, int num) {
        if (direction == 0 && row[num]) return true;
        if (direction == 1 && col[num]) return true;
        
        if (direction == 0) {
            for (int i=0; i<col.length; i++) {
                if (image[num][i] == '1') {
                    row[num] = true;
                    col[i] = true;
                    return true;
                }
            }
            return false;
        } else {
            for (int i=0; i<row.length; i++) {
                if (image[i][num] == '1') {
                    row[i] = true;
                    col[num] = true;
                    return true;
                }
            }
            return false;
        }
    }
}