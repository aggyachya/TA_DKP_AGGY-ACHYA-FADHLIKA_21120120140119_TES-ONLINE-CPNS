public class CheckCredential {
    private String [][] data = new String[3][2];
    private String email, password;

    CheckCredential(String email, String password){
        this.email = email;
        this.password = password;

        String [][] data = {
                {"aggyachya", "12345"},
                {"leomessi", "54321"},
                {"ronaldowati", "34512"}
        };
        this.data = data;
    }

    public boolean CheckLogin(){
        for(int i=0 ; i<data.length ; i++){
            if((data[i][0].equals(email)) && (data[i][1].equals(password))){
                return true;
            }
        }
        return false;
    }
}