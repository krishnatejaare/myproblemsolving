package datastructures;

public class HumanTowering {
    public void tower(Person[]a,int pos,boolean[]incl){
        if(pos==a.length){
            int max_height=Integer.MIN_VALUE;
            int max_pairs=Integer.MIN_VALUE;
           // int max_weight=Integer.MIN_VALUE;
            for(int i=0;i<a.length;i++){
                if(incl[i]){
                   if(a[i].height>max_height){
                       max_height=a[i].height;
                   }
                   else{
                       return;
                   }
                }
            }
            int count = 0;
            for (boolean var : incl) {
                count += (var ? 1 : 0);
            }
            if(count>max_pairs) max_pairs=count;
           // if(count==2||count==3) {
                for (int i = 0; i < a.length; i++) {
                    if (incl[i]) {
                        System.out.print(a[i].weight + "," + a[i].height + ":");
                    }

                }
                System.out.println();
           // }
            return;
        }
        tower(a,pos+1,incl);
        incl[pos]=true;
        tower(a,pos+1,incl);
        incl[pos]=false;
    }
    public static void main(String args[]) {
        HumanTowering t=new HumanTowering();
        Person p0=new Person(3,2);
        Person p1=new Person(5,9);
        Person p2=new Person(6,7);
        Person p3=new Person(7,8);
        Person[]array={p0,p1,p2,p3};
        //int[]array={2,9,7,8};
        boolean[]incl=new boolean[array.length];
        int pos=0;
        t.tower(array,pos,incl);


    }

    static class Person{
        private int weight;
        private int height;

        public Person(int weight,int height){
            this.weight=weight;
            this.height=height;
        }
        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}