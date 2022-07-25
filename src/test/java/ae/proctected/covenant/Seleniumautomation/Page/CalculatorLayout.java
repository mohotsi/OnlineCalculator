package ae.proctected.covenant.Seleniumautomation.Page;

import org.springframework.stereotype.Service;


public class CalculatorLayout {
private int canVas_x;
private int canVas_y;


    public CalculatorLayout(int buttonSquareSize) {
      this.canVas_x =buttonSquareSize;
      canVas_x=buttonSquareSize/2;

    }

    public int getCanVas_x() {
        return canVas_x;
    }

    public int getCanVas_y() {
        return canVas_y;
    }

    public CalculatorLayout(int buttonSquareSize, int buttonCentre) {
        this.canVas_x = buttonSquareSize;
        this.canVas_y = buttonCentre;
    }
    public CalculatorLayout zero(){
     return    new CalculatorLayout(-(canVas_x*2),canVas_y+(canVas_x*2)) ; // zero
    }
    public CalculatorLayout two(){
        return    new CalculatorLayout(-(canVas_x*2),canVas_y+(canVas_x)) ; // (calculator,-(canVas_x*2),button_0_y+(canVas_x*2)).
    }
    public CalculatorLayout dot(){
        return new CalculatorLayout(-(canVas_x),canVas_y+(canVas_x*2));
    }
    public CalculatorLayout signChange(){
        return new CalculatorLayout(0,canVas_y+(canVas_x*2));
    }
    public CalculatorLayout four(){
        return new CalculatorLayout(-(canVas_x*2),canVas_y);
    }
    public CalculatorLayout seven(){
        return new CalculatorLayout(-(canVas_x*2),canVas_y-canVas_x);
    }

}
