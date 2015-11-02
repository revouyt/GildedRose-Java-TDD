package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GildedRoseTest
{
	Item item1 = new Item("+5 Dexterity Vest", 10, 20);
	Item item2 = new Item("+4 Dexterity Vest", -10, 20);
	Item item3 = new Item("+3 Dexterity Vest", 10, -20);
	Item item4 = new Item("Aged Brie", 2, 0);
	Item item5 = new Item("Conjured Mana Cake", 2, 51);
	Item item6 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
	
	public Item startOfTheTests(Item item) 
	{
		int quality = item.getQuality();
		int sellIn = item.getSellIn();
		GildedRose.updateItem(item);
		return item;
	}
	
	@Test
	public void decrementQualityAndSellInEveryday()
	{
		Item item = startOfTheTests(item1);
		assertEquals(item.getSellIn(),9);
		assertEquals(item.getQuality(),19);	
	}


	@Test
	public void decrementQualityIfSellInIsInferiorToZero()
	{
		Item item = startOfTheTests(item2);
		assertEquals(item.getSellIn(),-11);
		assertEquals(item.getQuality(),18);
	}
	
	@Test
	public void setQualitySuperiorOrEqualToZero()
	{
		Item item = startOfTheTests(item3);
		assertEquals(item.getQuality(),0);
	}
	
	@Test
	public void changeQualityAndSellInForAgedBrie()
	{
		Item item = startOfTheTests(item4);
		assertEquals(item.getSellIn(),1);
		assertEquals(item.getQuality(),1);
	}
	
	@Test
	public void preventQualityFromBeingSuperiorTo50()
	{
		Item item = startOfTheTests(item5);
		assertEquals(item.getQuality(),80);
	}
	
	@Test
	public void preventItemsCalledSulfurasFromGettingUpdated()
	{
		Item item = startOfTheTests(item6);
		assertEquals(item.getSellIn(),0);
		assertEquals(item.getQuality(),50);
	}
}