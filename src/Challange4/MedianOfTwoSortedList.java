package Challange4;

import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedList{
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> newList = new ArrayList<>();
        for(int pointer1=0,pointer2=0;pointer1 < nums1.length || pointer2 < nums2.length;){
            if(pointer1 > nums1.length - 1){
                newList.add(nums2[pointer2++]);
            }else if(pointer2 > nums2.length - 1){
                newList.add(nums1[pointer1++]);
            }else{
                newList.add(
                    nums1[pointer1] > nums2[pointer2]?
                        nums2[pointer2++] :
                        nums1[pointer1++]
                );
            }
        }
        System.out.println(newList);
        int totalLength = nums1.length + nums2.length;
        return totalLength%2 > 0?
                newList.get(totalLength/2):
                (newList.get(totalLength/2 - 1) + newList.get((totalLength/2)))/2.0;

	}
}

/*
    Problem ->
    Given two sorted arrays nums1 and nums2 of size m and n respectively, 
    return the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n))

    Given :
        1 2
        3 4

        1(h1) 2
        3(h2) 4
        1 2(h1)
        3(h2) 4
        1 2 3 4


*/