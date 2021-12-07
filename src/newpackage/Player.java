/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author tekky
 */
public class Player {
    static double cash;
    static int lvl;
    double xp, xpReq, xpGained;
    static int water, yeast, nutrients, barrels, stills, sugar;
    static int batches;
    static int batchesCollected;
    static double mult;
    
    public Player() {
        cash = 4000;
        lvl = 0;
        xpReq = 200;
        xp = 0;
        
        water=0;yeast=0;nutrients=0;barrels=0;stills=0;sugar=0;batches=0;
        batchesCollected = 0;
        mult = 1;
    }
    
    public String getInv() {
        return "Water:                      " + water +
                "\nSugar:                      " + sugar + 
                "\nYeast:                       " + yeast +
                "\nYeast Nutrients:     " + nutrients +
                "\nBarrels:                    " + barrels +
                "\nShine Stills:             " + stills +
                "\nShine Batches:       " + batches;
    }
    
    public void getBatch(int n) {
        water-=3*n;sugar-=5*n;yeast-=n;nutrients-=n;barrels-=n;stills-=n;
        batches+=n;
        batchesCollected+=n;
        
        // xp system slowly being implemented
        for (int i=0;i<n;i++) doXP(10);
    }
    
    public void setInv(int x) {
        water = x;
        yeast = x;
        nutrients = x;
        barrels = x;
        stills = x;
        sugar = x;
        batches = x;
        mult = x;
    }
    
    public void doXP(double n) {
        xp += n*(1 + ((mult-1)*mult*.25));
        xpGained = n*(1 + ((mult-1)*mult*.25));
        while (xp>=xpReq) {
            xpReq*=2;
            lvl++;
        }
    }
    
    public double xpNeeded() {
        return xpReq-xp;
    }
}
