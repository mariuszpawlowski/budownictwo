UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o zgłoszenie budowlane', 'wniosek o zgłoszenie budowlane #A#/public/files/wn.zgloszenie_budowlane.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'oświadczenie o posiadanym prawie do dysponowania nieruchomością na cele budowlane', 'oświadczenie o posiadanym prawie do dysponowania nieruchomością na cele budowlane #A#/public/files/oswiadczenie_o_posiadanym_prawie_do_dysponowania_nieruchomoscia_na_cele_budowlane.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o wydanie decyzji o pozwolenie na budowę', 'wniosek o wydanie decyzji o pozwolenie na budowę #A#/public/files/pozwolenie_na_budowe_lub_rozbiorke.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'badań geotechnicznych', '#A#/application/searchexpression?expression=badanie+geotechniczne#BLANK#badań geotechnicznych#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'decyzja o warunkach zabudowy-dom wielorodzinny', 'decyzja o warunkach zabudowy-dom wielorodzinny #A#/public/files/wn._o_wydanie_decyzji_o_warunkach_zabudowy.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'decyzji środowiskowej', '#A#/application/searchexpression?expression=decyzja+%C5%9Brodowiskowa#BLANK#decyzji środowiskowej#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'Pozwolenie na budowę - potrzebne uzgodnienia', '#A#/application/searchexpression?expression=pozwolenie+na+budow%C4%99#BLANK#Pozwolenie na budowę - potrzebne uzgodnienia#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'Opłata skarbowa za wydanie pozwolenia na budowę', '#A#/application/searchexpression?expression=op%C5%82ata+skarbowa+za+wydanie+pozwolenia+na+budow%C4%99#BLANK#Opłata skarbowa za wydanie pozwolenia na budowę#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'pozwolenia na budowę', '#A#/application/searchexpression?expression=pozwolenie+na+budow%C4%99#BLANK#pozwolenia na budowę#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o pozwolenie na budowę', 'wniosek o pozwolenie na budowę #A#/public/files/pozwolenie_na_budowe_lub_rozbiorke.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek do zarządcy drogi o uzgodnienie lokalizacji zjazdu', 'wniosek do zarządcy drogi o uzgodnienie lokalizacji zjazdu #A#/public/files/wn._o_uzgodnienie_lokalizacji_zjazdu.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o uzgodnienie lokalizacji zjazdu', 'wniosek o uzgodnienie lokalizacji zjazdu #A#/public/files/wn._o_uzgodnienie_lokalizacji_zjazdu.doc#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'warunki zabudowy-zjazd z dr.powiatowej', 'warunki zabudowy-zjazd z dr.powiatowej #A#/public/files/warunki_zabudowy-zjazd_z_drpowiatowej.pdf#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'uzgodnienie lokalizacji zjazdu-z dr.gminnej', 'uzgodnienie lokalizacji zjazdu-z dr.gminnej #A#/public/files/uzgodnienie_lokalizacji_zjazdu-z_dr_gminnej.pdf#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'pozwolenie na budowę zjazdu ', 'pozwolenie na budowę zjazdu #A#/public/files/http://mario667.linuxpl.info:8080/public/decisions/pozwolenie_na_budowe-zjazd_z_drgminnej/pozwolenie_na_budowe-zjazd_z_drgminnej.pdf#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o uzgodnienie lokalizacji sieci wodociągowej w pasie drogowym ', 'wniosek o uzgodnienie lokalizacji sieci wodociągowej w pasie drogowym  #A#/public/files/wn._o_uzgodnienie_lokalizacji_sieci_w_pasie_drogowym.doc#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'wniosek o wydanie zezwolenia na prowadzenie robót budowlanych w pasie drogowym ', 'wniosek o wydanie zezwolenia na prowadzenie robót budowlanych w pasie drogowym   #A#/public/files/wn._o_wydanie_zezwolenia_na_zajecie_pasa_drogowego.doc#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'zgoda na lokalizację sieci w pasie drogowym', 'zgoda na lokalizację sieci w pasie drogowym    #A#/public/decisions/uzgodnienie_lokalizacji_sieci_w_pasie_drogowym/uzgodnienie_lokalizacji_sieci_w_pasie_drogowym.pdf#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'Procedury budowlane', '#A#/application/searchexpression?expression=procedury+budowlane+dla+inwestycji+wymagaj%C4%85cych+uzyskania+pozwolenia+na+budow%C4%99#BLANK#Procedury budowlane#/A#');

UPDATE buildings
SET additional_info  = REPLACE(additional_info, 'Zgłoszenie budowlane - potrzebne uzgodnienia', '#A#/application/searchexpression?expression=zg%C5%82oszenie+budowlane#BLANK#Zgłoszenie budowlane - potrzebne uzgodnienia#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Rozporządzenie Rady Ministrów z dnia 9 listopada 2010r. w sprawie przedsięwzięć mogących znacząco oddziaływać na środowisko', 'Rozporządzenie Rady Ministrów z dnia 9 listopada 2010r. w sprawie przedsięwzięć mogących znacząco oddziaływać na środowisko #A#/public/law/Rozporzadzenie_w_sprawie_inwestycji_znaczaco_oddzialywujacych_na_srodowisko.docx#BLANK#(pobierz)#/A#'); 

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Ustawa o drogach publicznych', 'Ustawa o drogach publicznych #A#/public/law/Drogi_publiczne.docx#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Ustawa z dnia 27 marca 2003 r. o planowaniu i zagospodarowaniu przestrzennym, z późń.zm.', 'Ustawa z dnia 27 marca 2003 r. o planowaniu i zagospodarowaniu przestrzennym, z późń.zm.  #A#/public/law/Planowanie_i_zagospodarowanie_przestrzenne.docx#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Ustawa z dnia 21 marca 1985 r. o drogach publicznych, z późń.zm.', 'Ustawa z dnia 21 marca 1985 r. o drogach publicznych, z późń.zm. #A#/public/law/Drogi_publiczne.docx#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, '#NOTARGET#', '#BLANK#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'zgody zarzadcy drogi na jej lokalizacje', 'zgody zarządcy drogi na jej lokalizację');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'uzgodnienie+lokalizacji+zjazdu+z+zarządcą+drogi', 'uzgodnienie+lokalizacji+zjazdu+z+zarz%C4%85dc%C4%85+drogi');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'zezwolenie+na+prowadzenie+robót+budowlanych+w+pasie+drogowym', 'zezwolenie+na+prowadzenie+rob%C3%B3t+budowlanych+w+pasie+drogowym');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Rozporządzenia ministra infrastruktury z dnia 3 lipca 2003 r. w sprawie szczegółowego zakresu i formy projektu budowlanego', 'Rozporządzenia ministra infrastruktury z dnia 3 lipca 2003 r. w sprawie szczegółowego zakresu i formy projektu budowlanego #A#/public/law/Forma_i_zakres_projektu_budowlanego.doc#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Planowanie i zagospodarowanie przestrzenne:', 'Planowanie i zagospodarowanie przestrzenne: #A#/public/law/Planowanie_i_zagospodarowanie_przestrzenne.docx#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Rozporządzenie Rady Ministrów  z dnia 9 listopada 2010 r. w sprawie przedsięwzięć mogących znacząco oddziaływać na środowisko', 'Rozporządzenie Rady Ministrów  z dnia 9 listopada 2010 r. w sprawie przedsięwzięć mogących znacząco oddziaływać na środowisko #A#/public/law/Rozporzadzenie_w_sprawie_inwestycji_znaczaco_oddzialywujacych_na_srodowisko.docx#BLANK#(pobierz)#/A#');

UPDATE buildings
SET law_other  = REPLACE(law_other, 'Planowanie i zagospodarowanie przestrzenne', 'Planowanie i zagospodarowanie przestrzenne #A#/public/law/Planowanie_i_zagospodarowanie_przestrzenne.docx#BLANK#(pobierz)#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, '#A#/public/decisions/pozwolenie_wodnoprawne-odprowadzenie_wod_do_rowu/pozwolenie_wodnoprawne-odprowadzenie_wod_do_rowu.pdf#BLANK#pozwolenie wodnoprawne#/A#', '#A#/application/searchexpression?expression=pozwolenie+wodnoprawne#BLANK#pozwolenie wodnoprawne#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'wniosek o pozwolenie wodnoprawne ', '#A#/public/files/wn.o_wydanie_pozwolenia_wodnoprawnego.doc#BLANK#wniosek o pozwolenie wodnoprawne #/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'Pozwolenie wodnoprawne', '#A#/application/searchexpression?expression=pozwolenie+wodnoprawne#BLANK#Pozwolenie wodnoprawne#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'Pozwolenie na budowę - potrzebne uzgodnienia', '#A#/application/searchexpression?expression=pozwolenie+na+budow%C4%99#BLANK#Pozwolenie na budowę - potrzebne uzgodnienia#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'wniosek o wydanie decyzji o pozwolenie na budowę', 'wniosek o wydanie decyzji o pozwolenie na budowę #A#/public/files/pozwolenie_na_budowe_lub_rozbiorke.doc#BLANK#(pobierz)#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'oświadczenie o posiadanym prawie do dysponowania nieruchomością na cele budowlane', 'oświadczenie o posiadanym prawie do dysponowania nieruchomością na cele budowlane #A#/public/files/oswiadczenie_o_posiadanym_prawie_do_dysponowania_nieruchomoscia_na_cele_budowlane.doc#BLANK#(pobierz)#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'wniosek o wydanie pozwolenia wodnoprawnego ', '#A#/public/files/wn.o_wydanie_pozwolenia_wodnoprawnego.doc#BLANK#wniosek o wydanie pozwolenia wodnoprawnego #/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'Procedury budowlane', '#A#/application/searchexpression?expression=procedury+budowlane+dla+inwestycji+wymagaj%C4%85cych+uzyskania+pozwolenia+na+budow%C4%99#BLANK#Procedury budowlane#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'Zgłoszenie budowlane - potrzebne uzgodnienia', '#A#/application/searchexpression?expression=zg%C5%82oszenie+budowlane#BLANK#Zgłoszenie budowlane - potrzebne uzgodnienia#/A#');

UPDATE expressions
SET additionalinformation  = REPLACE(additionalinformation, 'wniosek o zgłoszenie budowlane', 'wniosek o zgłoszenie budowlane #A#/public/files/wn.zgloszenie_budowlane.doc#BLANK#(pobierz)#/A#');

--

UPDATE expressions
SET law  = REPLACE(law, '#A#/application/searchexpression?expression=ocena+oddziaływania+inwestycji+na+środowisko#NOTARGET#przeprowadzenia oceny oddziaływania na środowisko#', '#A#/application/searchexpression?expression=ocena+oddzia%C5%82ywania+inwestycji+na+%C5%9Brodowisko#NOTARGET#przeprowadzenia oceny oddziaływania na środowisko#');

UPDATE expressions
SET law  = REPLACE(law, '#A#/application/searchexpression?expression=ocena+oddziaływania+na+obszar+natura+2000#NOTARGET#obszar NATURA 2000#/A#', '#A#/application/searchexpression?expression=ocena+oddzia%C5%82ywania+na+obszar+natura+2000#NOTARGET#obszar NATURA 2000#/A#');

UPDATE expressions
SET law  = REPLACE(law, '#NOTARGET#', '#BLANK#');



UPDATE buildings
SET additional_info  = REPLACE(additional_info, '#A#/application/searchexpression?expression=op%C5%82ata+skarbowa+za+wydanie+pozwolenia+na+budow%C4%99#BLANK#Opłata skarbowa za wydanie #A#/application/searchexpression?expression=pozwolenie+na+budow%C4%99#BLANK#pozwolenia na budowę#/A#', '#A#/application/searchexpression?expression=op%C5%82ata+skarbowa+za+wydanie+pozwolenia+na+budow%C4%99#BLANK#Opłata skarbowa za wydanie pozwolenia na budowę#/A#'); 






