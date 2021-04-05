import java.io.IOException;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key){
        this.alphabet="abcdefghiklmnopqrstuvwxyz";
        this.shiftedAlphabet=this.alphabet.substring(key)+this.alphabet.substring(0,key);
        this.mainKey=key;
    }
    public String encrypt(String input){
        StringBuilder sb=new StringBuilder(input);
        for(int i=0;i<sb.length();i++){
            int idx=this.alphabet.indexOf(sb.charAt(i));
            if(idx!=-1)
                sb.setCharAt(i,this.shiftedAlphabet.charAt(idx));
        }
        return sb.toString();
    }
    public String decrypt(String input){
        CaesarCipher cc=new CaesarCipher(26-mainKey);
        return cc.encrypt(input);
    }

}
