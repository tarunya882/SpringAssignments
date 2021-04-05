public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1,int key2){
        this.alphabet="abcdefghiklmnopqrstuvwxyz";
        this.shiftedAlphabet1=this.alphabet.substring(key1)+this.alphabet.substring(0,key1);
        this.shiftedAlphabet2=this.alphabet.substring(key2)+this.alphabet.substring(0,key2);
        this.mainKey1=key1;
        this.mainKey2=key2;
    }
    public String encrypt(String input){
        StringBuilder encryptedStr=new StringBuilder(input);
        for(int i=0;i<encryptedStr.length();i++){
            int idx=this.alphabet.indexOf(encryptedStr.charAt(i));
            if(idx!=-1&&i%2==0)
                encryptedStr.setCharAt(i,this.shiftedAlphabet1.charAt(idx));
            else if(idx!=-1&&(i%2)!=0)
                encryptedStr.setCharAt(i,this.shiftedAlphabet2.charAt(idx));
        }
        return encryptedStr.toString();
    }
    public String decrypt(String input){
        CaesarCipherTwo cc=new CaesarCipherTwo(26-mainKey1,26-mainKey2);
        return cc.encrypt(input);
    }
}

