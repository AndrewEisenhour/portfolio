import java.util.*;
class CopierReduction {
  public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    double A;
    double B;
    double C;
    double D;
    double shrink1;
    double shrink2;
    double shrink3;
    double shrink4;
    while(scan.hasNextLine()){
      A = scan.nextInt();
      
      B = scan.nextInt();
      C = scan.nextInt();
      D = scan.nextInt();
      if (A==0 || B==0 || C==0 || D==0){
        break;
      }
      /*if (A>B && C<D){
        int temp = C;
        C = D;
        D = temp;
      }*/
      if ((A<=C && B<=D) || (B<=C && A<=D)){
        System.out.println("100%");
      }
      else {
        shrink1 = C/A;
        shrink2 = D/B;
        shrink1 = Math.min(shrink1, shrink2);
        //System.out.println("Hello");
        shrink3 = C/B;
        shrink4 = D/A;
        shrink3 = Math.min(shrink3, shrink4);
        shrink1 = Math.max(shrink1, shrink3);
        shrink1 = shrink1 * 100;
        System.out.println((int)shrink1 + "%");
      }
      scan.nextLine();
      

    }

  }
}
