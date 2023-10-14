import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int pokeNum = Integer.parseInt(num[0]);
        int questionNum = Integer.parseInt(num[1]);

        Map<String, Integer> pokedexMap = new HashMap<>();
        List<String> pokedexList = new ArrayList<>();
        pokedexList.add("0");
        for(int i = 1; i <= pokeNum;i++){
            String pokemon = br.readLine();
            pokedexMap.put(pokemon, i);
            pokedexList.add(pokemon);
        }
        int idx;
        for(int i =0 ; i < questionNum ; i++){
            String findPokemon = br.readLine();
            if(findPokemon.charAt(0)>='A'){
                idx = pokedexMap.get(findPokemon);
                System.out.println(idx);
            } else{
                idx = Integer.parseInt(findPokemon);
                System.out.println(pokedexList.get(idx));
            }
        }
    }
}