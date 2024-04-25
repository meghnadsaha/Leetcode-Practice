package others;

public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter ( char[] letters , char target ) {
        int l=0;
        int h=letters.length-1;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(target<letters[mid])
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return letters[l%letters.length];
    }
    public static void main (String args[]){
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters,target));

    }
}
