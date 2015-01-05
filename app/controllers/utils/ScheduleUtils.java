package controllers.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ScheduleUtils {

	public static List<String> prepareCheckboxesSet(
			String mapaZasadniczaCheckBox, String zapewnienieDostawCheckBox,
			String srodowiskoPrawomocnaCheckBox, String wZDLCPCheckBox,
			String badaniaGeotechnioczneCheckBox,
			String zarzadcaDrogiZjazdCheckBox,
			String wylaczenieGruntowCheckBox, String wycinkaDrzewCheckBox,
			String pozwolenieWodnoprawneCheckBox,
			String uzgodnienieKonserwatorCheckBox,
			String uzgodnienieZUDPCheckBox, String uzgodnienieGestorzyCheckBox) {
		
		List<String> checkBoxSet = new ArrayList<String>();
		
		if (StringUtils.isNotEmpty(mapaZasadniczaCheckBox) && mapaZasadniczaCheckBox.equals("on")){
			checkBoxSet.add("mapaZasadniczaCheckBox");
		}
		
		if (StringUtils.isNotEmpty(zapewnienieDostawCheckBox) && zapewnienieDostawCheckBox.equals("on")){
			checkBoxSet.add("zapewnienieDostawCheckBox");
		}
		
		if (StringUtils.isNotEmpty(srodowiskoPrawomocnaCheckBox) && srodowiskoPrawomocnaCheckBox.equals("on")){
			checkBoxSet.add("srodowiskoPrawomocnaCheckBox");
		}
		
		if (StringUtils.isNotEmpty(wZDLCPCheckBox) && wZDLCPCheckBox.equals("on")){
			checkBoxSet.add("WZDLCPCheckBox");
		}
		
		if (StringUtils.isNotEmpty(badaniaGeotechnioczneCheckBox) && badaniaGeotechnioczneCheckBox.equals("on")){
			checkBoxSet.add("badaniaGeotechniczneCheckBox");
		}
		
		if (StringUtils.isNotEmpty(zarzadcaDrogiZjazdCheckBox) && zarzadcaDrogiZjazdCheckBox.equals("on")){
			checkBoxSet.add("zarzadcaDrogiZjazdCheckBox");
		}
		
		if (StringUtils.isNotEmpty(wylaczenieGruntowCheckBox) && wylaczenieGruntowCheckBox.equals("on")){
			checkBoxSet.add("wylaczenieGruntowCheckBox");
		}
		
		if (StringUtils.isNotEmpty(wycinkaDrzewCheckBox) && wycinkaDrzewCheckBox.equals("on")){
			checkBoxSet.add("wycinkaDrzewCheckBox");
		}
		
		if (StringUtils.isNotEmpty(pozwolenieWodnoprawneCheckBox) && pozwolenieWodnoprawneCheckBox.equals("on")){
			checkBoxSet.add("pozwolenieWodnoprawneCheckBox");
		}
		
		if (StringUtils.isNotEmpty(uzgodnienieKonserwatorCheckBox) && uzgodnienieKonserwatorCheckBox.equals("on")){
			checkBoxSet.add("uzgodnienieKonserwatorCheckBox");
		}
		
		if (StringUtils.isNotEmpty(uzgodnienieZUDPCheckBox) && uzgodnienieZUDPCheckBox.equals("on")){
			checkBoxSet.add("uzgodnienieZUDPCheckBox");
		}
		
		if (StringUtils.isNotEmpty(uzgodnienieGestorzyCheckBox) && uzgodnienieGestorzyCheckBox.equals("on")){
			checkBoxSet.add("uzgodnienieGestorzyCheckBox");
		}
		
		return checkBoxSet;
	}

}
