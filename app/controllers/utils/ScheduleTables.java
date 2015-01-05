package controllers.utils;

import java.util.ArrayList;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import play.i18n.Messages;
import static controllers.utils.Dictionary.*;

public class ScheduleTables {

	public static void table01(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
	
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}
	
	public static void table52(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);	
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table51(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);			
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table50(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
		
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table49(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
		
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table48(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table47(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table46(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table45(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table44(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table43(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table42(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table41(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table40(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table39(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table38(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table37(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table36(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table35(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table34(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table33(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table32(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table31(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table30(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table29(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table28(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table27(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table26(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table25(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table24(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table23(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table22(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table21(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table20(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table19(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table18(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table17(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table16(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table15(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table14(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table13(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table12(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table11(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table10(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table09(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table08(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table07(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table06(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table05(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table04(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table03(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<String> checkBoxSet, List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		checkBoxSet.add("mapaZasadniczaCheckBox");
		checkBoxSet.add("zapewnienieDostawCheckBox");
		
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wz_dlcp), new int[] {5,6,7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {6});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static void table02(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}

	public static List<ScheduleRow> prepareAdditionalRows(String uzgodnienieKonserwatorCheckBox,String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox, int month) {
		List<ScheduleRow> additionalRows = new ArrayList<ScheduleRow>(); 
		ScheduleRow row;
		if (StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) ){
			row = new ScheduleRow( Messages.get(uzgodnienie_konserwator), new int[] {month});
			additionalRows.add(row);
		}
		
		if (StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) ){
			row = new ScheduleRow( Messages.get(uzgodnienie_zudp), new int[] {month});
			additionalRows.add(row);
		}
		
		if (StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox)){
			row = new ScheduleRow( Messages.get(uzgodnienie_gestorzy), new int[] {month});
			additionalRows.add(row);
		}
		
		return additionalRows;
	}

	public static void table53(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
			scheduleRows.addAll(rows);
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month+1});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month+1, month+2, month+3});
			scheduleRows.add(row);
		} else {
			row = new ScheduleRow( Messages.get(uzgodnienie_rzeczoznawcy), new int[] {month});
			scheduleRows.add(row);
			row = new ScheduleRow( Messages.get(pozwolenie_budowa), new int[] {month, month+1, month+2});
			scheduleRows.add(row);
		}
	}


}
