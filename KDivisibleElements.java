import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDivisibleElements {
    
    public static int countDistinct(int[] nums, int k, int p) {
        Set<Integer> temp = new HashSet<>();
        int out = 0;
        Set<List<Integer>> myList = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i]%p == 0){
                temp.add(i);
            }
        }

        for(int i=0; i<nums.length; i++){
            int counter = 0;
            List<Integer> s = new ArrayList<>();
            for(int j=i; j<nums.length; j++){
                s.add(nums[j]);
                if(temp.contains(j)){
                    counter++;
                }
                if(counter<=k ){
                    if (!myList.contains(s)){
                        out++;
                        myList.add(new ArrayList<>(s));
                    }
                }else{
                    break;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2};
        System.out.println(countDistinct(nums,2,2));

    }
}
