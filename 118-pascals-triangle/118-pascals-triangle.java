class Solution {
    public List<List<Integer>> generate(int numRows) {
        int A=numRows;
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        for(int i=0;i<A;i++)
            pascalTriangle.add(new ArrayList<Integer>());
        System.out.println(pascalTriangle.size());
        A--;
        if(A>=0)
            pascalTriangle.get(0).add(1);
        if(A>=1){
            pascalTriangle.get(1).add(1);
            pascalTriangle.get(1).add(1);
        }
        for(int i=2;i<=A;i++){
            for(int j=0;j<=i/2;j++){
                if(j==0)
                    pascalTriangle.get(i).add(1);
                else
                    pascalTriangle.get(i).add(pascalTriangle.get(i-1).get(j-1)+pascalTriangle.get(i-1).get(j));
            }
            if(i%2==0){
                for(int j=(i/2)+1;j<=i;j++){
                    pascalTriangle.get(i).add(pascalTriangle.get(i).get(i-j));
                }
            }
            else{
                for(int j=(i/2)+1;j<=i;j++){
                    pascalTriangle.get(i).add(pascalTriangle.get(i).get(i-j));
                }
            }
        }
        return pascalTriangle;
    }
}