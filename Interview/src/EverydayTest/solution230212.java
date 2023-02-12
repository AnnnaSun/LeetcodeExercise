package src.EverydayTest;

public class solution230212 {
    public String alphabetBoardPath(String target) {
        String[] keyboard = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        StringBuilder res = new StringBuilder("");
        int prex= 0;
        int prey = 0;
        for (int i=0; i<target.length();i++){
            String c = String.valueOf(target.charAt(i));
            for (int y=0; y<keyboard.length;y++){
                if (keyboard[y].contains(c)){
                    int x = keyboard[y].indexOf(c);
                    if (prey==5){
                        if (y-prey>0)res.append(move("D", y-prey));
                        else if (y-prey<0)res.append(move("U", prey-y));
                        if (x-prex>0)res.append(move("R", x-prex));
                        else if (x-prex<0)res.append(move("L", prex-x));
                    }
                    else if (y==5){
                        if (x-prex>0)res.append(move("R", x-prex));
                        else if (x-prex<0)res.append(move("L", prex-x));
                        if (y-prey>0)res.append(move("D", y-prey));
                        else if (y-prey<0)res.append(move("U", prey-y));
                    }
                    else {
                        if (x-prex>0)res.append(move("R", x-prex));
                        else if (x-prex<0)res.append(move("L", prex-x));
                        if (y-prey>0)res.append(move("D", y-prey));
                        else if (y-prey<0)res.append(move("U", prey-y));
                    }
                    res.append("!");
                    prex = x;
                    prey = y;
                    break;
                }
            }
        }
        return res.toString();
    }

    public String move(String dir, int steps){
        StringBuilder s = new StringBuilder();
        for (int i=0; i<steps; i++){
            s.append(dir);
        }
        return s.toString();
    }
}
