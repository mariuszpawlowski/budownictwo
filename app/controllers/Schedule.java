package controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.record.ScenarioProtectRecord;

import controllers.utils.ScheduleRow;
import controllers.utils.ScheduleTables;
import controllers.utils.ScheduleUtils;


import play.data.validation.Required;
import play.i18n.Messages;
import play.mvc.Controller;
import static play.modules.pdf.PDF.*;
import static controllers.utils.Dictionary.*;
public class Schedule extends Controller {
	
	
	public static void index(String mapaZasadniczaCheckBox, String zapewnienieDostawCheckBox, String srodowiskoPrawomocnaCheckBox, String WZDLCPCheckBox, String badaniaGeotechniczneCheckBox, 
			String zarzadcaDrogiZjazdCheckBox, String wylaczenieGruntowCheckBox, String wycinkaDrzewCheckBox, String pozwolenieWodnoprawneCheckBox, String uzgodnienieKonserwatorCheckBox, 
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox){
		
		ScheduleRow row;
		
		List<String> checkBoxSet = ScheduleUtils.prepareCheckboxesSet(mapaZasadniczaCheckBox, zapewnienieDostawCheckBox, srodowiskoPrawomocnaCheckBox, WZDLCPCheckBox, badaniaGeotechniczneCheckBox, 
				zarzadcaDrogiZjazdCheckBox, wylaczenieGruntowCheckBox, wycinkaDrzewCheckBox, pozwolenieWodnoprawneCheckBox, uzgodnienieKonserwatorCheckBox, 
				uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox);
		
		List<ScheduleRow> scheduleRows = new ArrayList<ScheduleRow>();
		
		// wariant standardowy nic nie wybrane
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table01(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
			
		}
		
//		wariant "dec.srod."
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && srodowiskoPrawomocnaCheckBox.equals("on") && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			
			
			ScheduleTables.table02(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table03(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
//		wariant "WZ lub DLCP"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table04(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "bad.geotechniczne"

		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table05(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		// 	wariant "bad.geotechniczne+WZ lub DLCP"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table06(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		// wariant "dec.środ"+"WZ lub DLCP"+ bad.geotechniczne

		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table07(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.srod." + "bad.geotechniczne"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table08(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		//wariant "uzg. z zarzadcą drogi"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table09(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		//wariant "uzg. z zarzadcą drogi"+"bad.geotechniczne"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table10(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		//wariant "WZ lub DLCP"+"uzg.z zarz.dr."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
		
			ScheduleTables.table11(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.srod."+"uzg. z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table12(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
				
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"uzg. z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table13(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.srod."+"uzg. z zarz.dr."+"bad.geotechniczne"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table14(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"uzg.z zarz.dr."+"bad.geotechniczne"

		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table15(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"uzg.z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table16(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "wył.gr.z prod.rolnej lub leśnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table17(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
			
		}
		
//		wariant "dec.srod."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table18(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"wył.gr.z prod.rolnej lub leśnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table19(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table20(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table21(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
//		wariant "dec.srod." + "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table22(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}

//		wariant "bad.geotechniczne+WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table23(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"wył.gr.z pod.rolnej lub lesnej"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table24(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "uzg. z zarzadcą drogi"+"wył.gr.z prod.rolnej lub leśnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table25(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"uzg. z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table26(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"uzg.z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table27(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"uzg. z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table28(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "uzg. z zarzadcą drogi"+"wył.gr.z prod.rolnej lub leśnej"+"bad.geotech."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table29(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
			
		}
		
//		wariant "dec.srod." + "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej+"uzg.z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table30(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "bad.geotechniczne+WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"+"uzg.z zarz.dr."
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			ScheduleTables.table31(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"wył.gr.z pod.rolnej lub lesnej"+"uzg.z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table32(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "pozw. na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table33(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table34(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}

//		wariant "WZ lub DLCP"+"pozw. na wycinke drzew lub krzewowo"
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table35(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table36(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "bad.geotechniczne"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table37(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod." + "bad.geotechniczne"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table38(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "bad.geotechniczne+WZ lub DLCP"+"pozw. na wycinke drzew lub krzewowo"
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table39(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+ bad.geotechniczne +"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table40(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "uzg. z zarzadcą drogi"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table41(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"uzg. z zarz.dr."+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table42(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"uzg.z zarz.dr."+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table43(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"uzg. z zarz.dr."+"pozw. na wycinke drzew lub krzewowo"
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table44(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "wył.gr.z prod.rolnej lub leśnej"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table45(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"wył.gr.z prod.rolnej lub lesnej"+"pozw. na wycinke drzew lub krzewowo"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table46(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		
//		wariant "WZ lub DLCP"+"wył.gr.z prod.rolnej lub leśnej"+"pozw. na wycinke drzew lub krzewowo"
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table47(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"+"pozw. na wycinke drzew lub krzewowo"

		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			ScheduleTables.table48(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		//wariant "uzg. z zarzadcą drogi"+"bad.geotechniczne"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			
			ScheduleTables.table49(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"uzg. z zarz.dr."+"bad.geotechniczne"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table50(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"uzg.z zarz.dr."+"bad.geotechniczne"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			ScheduleTables.table51(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}

//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"uzg.z zarz.dr."+"pozw.na wycinke drzew lub krzewow"
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			ScheduleTables.table52(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
	
		//wariant "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			ScheduleTables.table53(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod." + "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table54(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "bad.geotechniczne+WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table55(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
	
//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"wył.gr.z pod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table56(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
	
//		wariant "uzg. z zarzadcą drogi"+"wył.gr.z prod.rolnej lub leśnej"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table57(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
	
//		wariant "dec.srod."+"uzg. z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table58(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
	
//		wariant "WZ lub DLCP"+"uzg.z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table59(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}

//		wariant "dec.środ"+"WZ lub DLCP"+"uzg. z zarz.dr."+"wył.gr.z prod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table60(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej+"pozw.na wycinke drzew lub krzewow"+"uzg. z zarz.dr."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table61(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod." + "bad.geotechniczne"+"wył.gr.z prod.rolnej lub lesnej+"pozw.na wycinke drzew lub krzewow"+"uzg. z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table62(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "bad.geotechniczne+WZ lub DLCP"+"wył.gr.z prod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"+"uzg. z zarz.dr."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table63(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+ "bad.geotechniczne"+"wył.gr.z pod.rolnej lub lesnej"+"pozw.na wycinke drzew lub krzewow"+"uzg. z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table64(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "pozw.wodnopr."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table65(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table66(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"pozw.wodnopr."

		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table67(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table68(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "pozw.wodnopr."+"bad.geotech."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table69(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."+"bad.geotech."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table70(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
//		wariant "WZ lub DLCP"+"pozw.wodnopr."+"bad.geotech."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table71(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."+"bad.geotech."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table72(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		
		//wariant "pozw.wodnopr."+"uzg.z zarz.dr."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table73(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."+"uzg.z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table74(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"pozw.wodnopr."+"uzg.z zarz.dr"

		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table75(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."+"uzg. z zarz.dr."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table76(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
/*//		mapa zasadnicza 
//		zapewnienie dostaw od gestorów sieci
		if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox) && StringUtils.isNotEmpty(zapewnienieDostawCheckBox) && StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table77(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		mapa zasadnicza 
		if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox) && StringUtils.isEmpty(zapewnienieDostawCheckBox) && StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table77a(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		zapewnienie dostaw od gestorów sieci
		if (StringUtils.isEmpty(mapaZasadniczaCheckBox) && StringUtils.isNotEmpty(zapewnienieDostawCheckBox) && StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table77b(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}*/
		
//		wariant "pozw.wodnopr."+"uzg.z zarz.dr."+bad.geotech."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table78(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."+"uzg.z zarz.dr."+"bad.geotech."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table79(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"pozw.wodnopr."+"uzg.z zarz.dr"+bad.geot."
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table80(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."+"uzg. z zarz.dr."+"bad.geot."
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table81(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		
//		wariant "pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table82(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table83(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"
		if (StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table84(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table85(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"+"bad.geot."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table86(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "dec.srod."+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"+"bad.geot."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table87(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		wariant "WZ lub DLCP"+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"+"bad.geot."
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table88(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		wariant "dec.środ"+"WZ lub DLCP"+"pozw.wodnopr."+"wył.gr.z prod.rolnej lub lesnej"+"bad.geot."
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table89(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
//		pozwolenie wodnoprawne-prawomocne
//		wył.gr.z prod.rolnej lub lesnej
//		uzg.z zarz.dr.

		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table90(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
//		decyzja środowiskowa-prawomocna
//		uzg.z zarz.dr.
//		wył.gr.z prod.rolnej lub lesnej
//		pozwolenie wodnoprawne-prawomocne
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table91(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
/*		
		WZ lub DLCP-prawomocne
		uzg.z zarz.dr.
		wył.gr.z prod.rolnej lub lesnej
		pozwolenie wodnoprawne-prawomocne
*/
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table92(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*		
		WZ lub DLCP-prawomocne
		uzg.z zarz.dr.
		wył.gr.z prod.rolnej lub lesnej
		pozwolenie wodnoprawne-prawomocne
		decyzja środowiskowa-prawomocna
		decyzja środowiskowa-prawomocna


*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table93(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*
		 * pozwolenie wodnoprawne-prawomocne
			bad.geotechn.
			wył.gr.z prod.rolnej lub lesnej
			uzg.z zarz.dr.

		 */
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table94(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*
		 * pozwolenie wodnoprawne-prawomocne
			bad.geotechn.
			wył.gr.z prod.rolnej lub lesnej
			uzg.z zarz.dr.
			decyzja środowiskowa-prawomocna


		 */
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table95(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*
		 * pozwolenie wodnoprawne-prawomocne
			bad.geotechn.
			wył.gr.z prod.rolnej lub lesnej
			uzg.z zarz.dr.
			WZ lub DLCP-prawomocne
		 */
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			

			table96(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*
		 * pozwolenie wodnoprawne-prawomocne
			bad.geotechn.
			wył.gr.z prod.rolnej lub lesnej
			uzg.z zarz.dr.
			WZ lub DLCP-prawomocne
			decyzja środowiskowa-prawomocna

		 */
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table97(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*pozwolenie wodnoprawne-prawomocne
pozw.na wycinke drzew lub krzewow

*/
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table98(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*decyzja środowiskowa-prawomocna
pozwolenie wodnoprawne-prawomocne
pozw.na wycinke drzew lub krzewow
*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table99(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*
		 * 
WZ lub DLCP-prawomocne
pozwolenie wodnoprawne-prawomocne
pozw.na wycinke drzew lub krzewow

		 */
		
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table100(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*
		 * 
WZ lub DLCP-prawomocne
pozwolenie wodnoprawne-prawomocne
pozw.na wycinke drzew lub krzewow
decyzja środowiskowa-prawomocna

		 */
		
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table101(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
/*		pozwolenie wodnoprawne-prawomocne
		bad.geotechn
		pozw.na wycinke drzew lub krzewow
*/
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table102(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*		pozwolenie wodnoprawne-prawomocne
		bad.geotechn
		pozw.na wycinke drzew lub krzewow
		decyzja środowiskowa-prawomocna

*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table103(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		
		/*		pozwolenie wodnoprawne-prawomocne
		bad.geotechn
		pozw.na wycinke drzew lub krzewow
		WZ lub DLCP-prawomocne
*/
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table104(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*		pozwolenie wodnoprawne-prawomocne
		bad.geotechn
		pozw.na wycinke drzew lub krzewow
		WZ lub DLCP-prawomocne
		decyzja środowiskowa-prawomocna

*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table105(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*pozwolenie wodnoprawne-prawomocne
uzg.z zarz.dr.
pozw.na wycinke drzew lub krzewow */

		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table106(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*decyzja środowiskowa-prawomocna
pozwolenie wodnoprawne-prawomocne
uzg.z zarz.dr.
pozw.na wycinke drzew lub krzewow */
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table107(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*wz
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		pozw.na wycinke drzew lub krzewow */
				if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
						StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
						StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
					table109(uzgodnienieKonserwatorCheckBox,
							uzgodnienieZUDPCheckBox,
							uzgodnienieGestorzyCheckBox, checkBoxSet,
							scheduleRows);
				}		
				/*wz
				pozwolenie wodnoprawne-prawomocne
				uzg.z zarz.dr.
				decyzja środowiskowa-prawomocna
				pozw.na wycinke drzew lub krzewow */
				
				if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
						StringUtils.isEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
						StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
					table110(uzgodnienieKonserwatorCheckBox,
							uzgodnienieZUDPCheckBox,
							uzgodnienieGestorzyCheckBox, checkBoxSet,
							scheduleRows);
				}						
/*bad.geotechn.
pozwolenie wodnoprawne-prawomocne
uzg.z zarz.dr.
pozw.na wycinke drzew lub krzewow
*/				
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table111(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		decyzja środowiskowa-prawomocna
		pozw.na wycinke drzew lub krzewow
		*/		
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table112(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		wz
		pozw.na wycinke drzew lub krzewow
		*/		
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table113(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		wz
		srodowisko
		pozw.na wycinke drzew lub krzewow
		*/		
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			table114(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		/*bad.geotechn.
pozwolenie wodnoprawne-prawomocne
uzg.z zarz.dr.
wył.gr.z prod.rolnej lub lesnej
pozw.na wycinke drzew lub krzewow*/

		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table115(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		srod
		wył.gr.z prod.rolnej lub lesnej
		pozw.na wycinke drzew lub krzewow*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox)){
				row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
				scheduleRows.add(row);
			}
			if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox)){
				row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
				scheduleRows.add(row);
			}
			table116(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, scheduleRows);
		}
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		wz
		wył.gr.z prod.rolnej lub lesnej
		pozw.na wycinke drzew lub krzewow*/
		if ( StringUtils.isEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table117(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		
		/*bad.geotechn.
		pozwolenie wodnoprawne-prawomocne
		uzg.z zarz.dr.
		wz
		srod
		wył.gr.z prod.rolnej lub lesnej
		pozw.na wycinke drzew lub krzewow*/
		if ( StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && StringUtils.isNotEmpty(WZDLCPCheckBox) && 
				StringUtils.isNotEmpty(badaniaGeotechniczneCheckBox) && StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && 
				StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox)    ){
			
			table118(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox,
					uzgodnienieGestorzyCheckBox, checkBoxSet, scheduleRows);
		}
		
		render(checkBoxSet, scheduleRows);
	}

	private static void table118(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table117(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table116(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table115(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table114(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table113(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table112(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table111(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table110(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table109(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table107(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table106(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table105(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table104(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table103(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table102(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table101(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table100(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table99(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table98(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table97(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table96(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table95(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table94(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table93(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table92(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table91(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table90(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table89(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table88(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table87(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table86(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table85(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table84(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table83(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table82(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table81(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table80(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table79(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table78(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(badania_geotechniczne), new int[] {2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table77(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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
	
	private static void table77a(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_zasadnicza), new int[] {1});
		scheduleRows.add(row);
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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
	
	private static void table77b(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(gestorzy), new int[] {1});
		scheduleRows.add(row);
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table76(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table75(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table74(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(decyzja_srodowiskowa), new int[] {2,3,4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table73(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table72(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table71(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table70(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table69(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table68(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {7,8});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table67(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table66(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {4,5});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table65(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(pozwolenie_wodnoprawne), new int[] {2,3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table64(String uzgodnienieKonserwatorCheckBox,
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table63(String uzgodnienieKonserwatorCheckBox,
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table62(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
					
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table61(String uzgodnienieKonserwatorCheckBox,
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
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table60(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table59(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table58(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {3});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table57(String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox,
			List<ScheduleRow> scheduleRows) {
		ScheduleRow row;
		row = new ScheduleRow( Messages.get(mapa_projektowa), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(koncepcja_zagospodarowania), new int[] {1,2});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(uzgodnienie_zjazd), new int[] {1});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {2,3});
		scheduleRows.add(row);
		
		int month = 3;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table56(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {7});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {7,8});
		scheduleRows.add(row);
		int month = 8;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table55(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wylaczenie_gruntow), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(warunki_przylaczeniowe), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {4,5});
		scheduleRows.add(row);
		int month = 5;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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

	private static void table54(String uzgodnienieKonserwatorCheckBox,
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
		row = new ScheduleRow( Messages.get(wycinka_drzew), new int[] {4});
		scheduleRows.add(row);
		row = new ScheduleRow( Messages.get(projekt_wielobranzowy), new int[] {3,4});
		scheduleRows.add(row);
		int month = 4;
		if ( StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) || StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) || StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) ){
			List<ScheduleRow> rows = ScheduleTables.prepareAdditionalRows(uzgodnienieKonserwatorCheckBox, uzgodnienieZUDPCheckBox, uzgodnienieGestorzyCheckBox, month+1);
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
