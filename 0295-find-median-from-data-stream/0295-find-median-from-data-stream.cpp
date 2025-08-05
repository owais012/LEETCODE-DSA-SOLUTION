#include<bits/stdc++.h>
using namespace std;

template<typename T>
class heap{
private:
    vector<T>arr;
    int last;
    bool minHip;
public:
    heap(bool mh) : last(0), minHip(mh){
      arr.push_back(T(-1));
    }
    bool compare(T a, T b){
        //logic to be added for custom comparater
        if(minHip)
            return a < b;
        return a > b;
    }

    void balancePush(){
        int par = last, child = last;
        while(par >= 1 && !compare(arr[par], arr[child])){
            swap(arr[par],arr[child]);
            child = par;
            par /= 2;
        }
    }

    void balancePop(){
        int par = 1, left = 2, right = 3;

        while(true){
            if(left > last)
                break;
            if(right > last){
                if(!compare(arr[par], arr[left])){
                    swap(arr[par], arr[left]);
                }
                break;
            }
            if(compare(arr[right] , arr[left])){
                swap(arr[right], arr[par]);
                par = right;
                left = right*2;
                right = 2*right+1;
            }else{
                swap(arr[left], arr[par]);
                par = left;
                left *=2;
                right = 2*left+1;
            }
        }
    }

    void push(T val){
        //so when an obj is pushed, it get inserted as the last child from left to right virtually,
        //but actually it get added as the last element in vector<T>, and then rearranged accordoing to value
        arr.push_back(val);
        last++;
        balancePush();
    }

    T top(){
        if(!empty())
            return arr[1];
        throw std::out_of_range("Heap is empty");
    }

    void pop(){
        if(!empty()){
            swap(arr[1],arr[last]);
            last--;
            arr.pop_back();
            balancePop();
        }else{
            throw std::out_of_range("Heap is empty");
        }
    }

    bool empty(){
        return last == 0;
    }

    int size(){
        return last;
    }
};


class MedianFinder {
public:
    bool minHeap = true;
    // heap<double> h1;
    // heap<double> h2;
    priority_queue<double, vector<double>, greater<double>>h2;
    priority_queue<double>h1;
    MedianFinder()  {
// : h1(!minHeap), h2(minHeap)
    }
    
    void addNum(int num) {
        // 0<= h2.size - h1.size() <= 1; 
        h1.push(num);
        while(h1.size() > h2.size()){
            h2.push(h1.top());
            h1.pop();
        }
        while(h1.size()> 0 && h1.top() > h2.top()){
            h2.push(h1.top());
            h1.pop();
            h1.push(h2.top());
            h2.pop();
        }
        // cout<<h2.top()<<endl;
    }
    
    double findMedian() {
        if(h1.size() < h2.size()){
            return h2.top();
        }
        if(h1.size() > h2.size()){
            return h1.top();
        }
        return (h1.top()+h2.top())/2.0;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */