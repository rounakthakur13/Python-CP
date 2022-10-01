#include<bits/stdc++.h>
using namespace std;

int main(){

    int arr[] = {4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
    //int arr[] = {1,2,3,-2,5};
    int n = sizeof(arr)/sizeof(arr[0]);
    int current = arr[0];
    int overall = arr[0];

    for(int i = 1; i < n; i++){
        if(arr[i] > current + arr[i]){
            current = arr[i];
            if(current > overall){
                overall = current;
            }
        }
        else{
            current = arr[i] + current;
            if(current > overall){
                overall = current;
            }
        }
    }

    cout << overall;



}