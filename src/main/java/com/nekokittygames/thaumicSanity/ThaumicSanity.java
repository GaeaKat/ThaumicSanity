package com.nekokittygames.thaumicSanity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.config.ConfigRecipes;
import thaumcraft.common.config.ConfigResearch;
import thaumcraft.common.lib.research.ResearchManager;

@Mod(modid = ThaumicSanity.MODID, version = ThaumicSanity.VERSION,dependencies =ThaumicSanity.DEPENDENCES)
public class ThaumicSanity
{
    public static final String MODID = "thaumicsanity";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCES = "required-after:Thaumcraft";

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        ResearchCategories.researchCategories.get("ELDRITCH").research.remove("ELDRITCHMINOR");
        (new ResearchItem("ELDRITCHMINOR", "BASICS", new AspectList().add(Aspect.ELDRITCH,3).add(Aspect.MAGIC,3).add(Aspect.VOID,3), 1, 5, 5, new ResourceLocation("thaumcraft", "textures/misc/r_eldritchminor.png"))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.ELDRITCHMINOR.1"), new ResearchPage((CrucibleRecipe) ConfigResearch.recipes.get("VoidSeed"))}).setRound().setParents("RESEARCHER2").setParentsHidden("RESEARCHER1","INFUSION").setSpecial().registerResearchItem();
        ResearchCategories.researchCategories.get("ELDRITCH").research.remove("ELDRITCHMAJOR");
        (new ResearchItem("ELDRITCHMAJOR", "ELDRITCH", new AspectList().add(Aspect.ELDRITCH,3).add(Aspect.MAGIC,3).add(Aspect.VOID,3), -1, 0, 0, new ResourceLocation("thaumcraft", "textures/misc/r_eldritchmajor.png"))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.ELDRITCHMAJOR.1"), new ResearchPage("tc.research_page.ELDRITCHMAJOR.2")}).setRound().setSpecial().setParents("ELDRITCHMINOR","CRIMSON").registerResearchItem();
        ResearchCategories.researchCategories.get("ALCHEMY").research.remove("BATHSALTS");
        (new ResearchItem("BATHSALTS", "ALCHEMY", (new AspectList()).add(Aspect.MIND, 3).add(Aspect.AURA, 3).add(Aspect.ORDER, 3).add(Aspect.HEAL, 3), -4, -4, 2, new ItemStack(ConfigItems.itemBathSalts))).setPages(new ResearchPage[]{new ResearchPage("tc.research_page.BATHSALTS.1"), new ResearchPage((CrucibleRecipe)ConfigResearch.recipes.get("BathSalts"))}).setParents("ALCHEMICALMANUFACTURE").registerResearchItem();
    }
}
