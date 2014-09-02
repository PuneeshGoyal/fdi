package net.txm.fdi.constants;

/**
 * Created by Akki on 8/27/2014.
 */
public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String ANSWER;

    public Question()
    {
        ID			= 0;
        QUESTION	= "";
        OPTA		= "";
        OPTB		= "";
        OPTC		= "";
        OPTD		= "";
        ANSWER		= "";
    }

    public String getOPTD() 
    {
        return OPTD;
    }

    public void setOPTD(String OPTD) 
    {
        this.OPTD = OPTD;
    }

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,String oPTD, String aNSWER) 
    {
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD=  oPTD;
        ANSWER = aNSWER;
    }

    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public void setOPTA(String OPTA) {
        this.OPTA = OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public void setOPTB(String OPTB) {
        this.OPTB = OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public void setOPTC(String OPTC) {
        this.OPTC = OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setANSWER(String ANSWER) {
        this.ANSWER = ANSWER;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}