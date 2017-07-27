/**
 * Created by 민우 on 2017-07-22.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    private final HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<>();
    
    public ArrayList<Pokemon> getPokemons(String name) {
        return pokemons.get(name);
    }

    public void add(Pokemon pokemon) {
        // Data Put in ArrayList, HashMap
        String name = pokemon.name;
        if (getPokemons(name)==null){
            pokemons.put(name, new ArrayList<Pokemon>());
        }
        getPokemons(name).add(pokemon);
    }

    public Pokemon getStrongest(String name) {
        // name 이름의 포켓몬 목록
        ArrayList<Pokemon> pokemonList = getPokemons(name);
        if (pokemonList==null){
            return null;
        }
        Pokemon strongest = null;

        // Strongest Pokemon Search in the Same Name
        for (Pokemon pokemon : pokemonList){
            if (strongest==null || pokemon.cp > strongest.cp){
                strongest=pokemon;
            }
        }
        return strongest;
    }

    public Pokemon getStrongest() {
        // Strongest Pokemon Search in PokeBag
        Pokemon strongest = null;
        for (String key : pokemons.keySet()){
            Pokemon p = getStrongest(key);
            if (strongest==null || p.cp > strongest.cp) {
                strongest=p;
            }
        }
        return strongest;
    }
}