package commands;

public class Util 
{
	public static String baseEvolution(String in)
	{
		String lower = in.toLowerCase();
		if(lower.equals("jolteon") || lower.equals("vaporeon") || lower.equals("flareon"))
			return "Eevee";
		if(lower.equals("ivysaur") || lower.equals("venusaur"))
			return "Bulbasaur";
		if(lower.equals("charmeleon") || lower.equals("charizard"))
			return "Charmander";
		if(lower.equals("wartortle") || lower.equals("blastoise"))
			return "Squirtle";
		if(lower.equals("metapod") || lower.equals("butterfree"))
			return "Caterpie";
		if(lower.equals("kakuna") || lower.equals("beedrill"))
			return "Weedle";
		if(lower.equals("nidorina") || lower.equals("nidoqueen"))
			return "NidoranF";
		if(lower.equals("nidorino") || lower.equals("nidoking"))
			return "NidoranM";
		if(lower.equals("kadabra") || lower.equals("alakazam"))
			return "Abra";
		if(lower.equals("haunter") || lower.equals("gengar"))
			return "Gastly";
		if(lower.equals("machoke") || lower.equals("machamp"))
			return "Machop";
		if(lower.equals("graveler") || lower.equals("golem"))
			return "Geodude";
		if(lower.equals("weepinbell") || lower.equals("victreebel"))
			return "Bellsprout";
		if(lower.equals("gloom") || lower.equals("vileplume"))
			return "Oddish";
		if(lower.equals("poliwhirl") || lower.equals("poliwrath"))
			return "Poliwag";
		if(lower.equals("pidgeotto") || lower.equals("pidgeot"))
			return "Pidgey";
		if(lower.equals("dragonair") || lower.equals("dragonite"))
			return "Dratini";
		if(lower.equals("raichu"))
			return "Pikachu";
		if(lower.equals("slowbro"))
			return "Slowpoke";
		if(lower.equals("rapidash"))
			return "Ponyta";
		if(lower.equals("hypno"))
			return "Drowzee";
		if(lower.equals("raticate"))
			return "Rattata";
		if(lower.equals("arcanine"))
			return "Growlithe";
		if(lower.equals("magneton"))
			return "Magnemite";
		if(lower.equals("muk"))
			return "Grimer";
		if(lower.equals("cloyster"))
			return "Shellder";
		if(lower.equals("dewgong"))
			return "Seel";
		if(lower.equals("venomoth"))
			return "Venonat";
		if(lower.equals("magneton"))
			return "Magnemite";
		if(lower.equals("rhydon"))
			return "Rhyhorn";
		if(lower.equals("weezing"))
			return "Koffing";
		if(lower.equals("fearow"))
			return "Spearow";
		if(lower.equals("arbok"))
			return "Ekans";
		if(lower.equals("sandslash"))
			return "Sandshrew";
		if(lower.equals("dodrio"))
			return "Doduo";
		if(lower.equals("tentacruel"))
			return "Tentacool";
		if(lower.equals("seaking"))
			return "Goldeen";
		if(lower.equals("seadra"))
			return "Horsea";
		if(lower.equals("starmie"))
			return "Staryu";
		if(lower.equals("omastar"))
			return "Omanyte";
		if(lower.equals("kabutops"))
			return "Kabuto";
		if(lower.equals("dugtrio"))
			return "Diglett";
		if(lower.equals("persian"))
			return "Meowth";
		if(lower.equals("psyduck"))
			return "Golduck";
		if(lower.equals("marowak"))
			return "Cubone";
		if(lower.equals("exeggcutor"))
			return "Exeggcute";
		if(lower.equals("electrode"))
			return "Voltorb";
		if(lower.equals("wigglytuff"))
			return "Jigglypuff";
		if(lower.equals("clefable"))
			return "Clefairy";
		if(lower.equals("parasect"))
			return "Paras";
		if(lower.equals("golbat"))
			return "Zubat";
		if(lower.equals("ninetails"))
			return "Vulpix";
		return in;
	}
}
