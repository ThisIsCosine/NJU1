#include "kth-largest-element.h"

#include <iostream>
using namespace std;





int findKthLargest(int a[], int n, int K) {
    for (int i = 0; i < n - 1; i++) {
			for (int i1 = 0; i1 < n - 1 - i ; i1++) {
				if (a[i1] < a[i1 + 1]){
					int tmp =   a[i1];
					a[i1] = a[i1 + 1];
					a[i1 + 1] = tmp;
				}
			}
		}
		return  a[K - 1];

}



