package net.mcreator.beingmod.procedures;

@BeingmodModElements.ModElement.Tag
public class KjaldarcrystalAdditionalGenerationConditionProcedure extends BeingmodModElements.ModElement {

	public KjaldarcrystalAdditionalGenerationConditionProcedure(BeingmodModElements instance) {
		super(instance, 91);

	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure KjaldarcrystalAdditionalGenerationCondition!");
			return false;
		}

		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");

		boolean T = false;
		if ((y <= 10)) {
			T = (boolean) (true);
		} else {
			T = (boolean) (false);
		}
		return (T);

	}

}
