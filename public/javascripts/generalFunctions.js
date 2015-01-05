        function UpdateTableHeaders() {
            $("div.divTableWithFloatingHeader").each(function() {
                var originalHeaderRow = $(".tableFloatingHeaderOriginal", this);
                var floatingHeaderRow = $(".tableFloatingHeader", this);
                var offset = $(this).offset();
                var scrollTop = $(window).scrollTop();
                if ((scrollTop > offset.top) && (scrollTop < offset.top + $(this).height())) {
                    floatingHeaderRow.css("visibility", "visible");
                    floatingHeaderRow.css("top", Math.min(scrollTop - offset.top, $(this).height() - floatingHeaderRow.height()) + "px");

                    // Copy cell widths from original header
                    $("th", floatingHeaderRow).each(function(index) {
                        var cellWidth = $("th", originalHeaderRow).eq(index).css('width');
                        $(this).css('width', cellWidth);
                    });

                    // Copy row width from whole table
                    floatingHeaderRow.css("width", $(this).css("width"));
                }
                else {
                    floatingHeaderRow.css("visibility", "hidden");
                    floatingHeaderRow.css("top", "0px");
                }
            });
        }

        $(document).ready(function() {
            $("table.tableWithFloatingHeader").each(function() {
                $(this).wrap("<div class=\"divTableWithFloatingHeader\" style=\"position:relative\"></div>");

                var originalHeaderRow = $("tr:first", this)
                originalHeaderRow.before(originalHeaderRow.clone());
                var clonedHeaderRow = $("tr:first", this)

                clonedHeaderRow.addClass("tableFloatingHeader");
                clonedHeaderRow.css("position", "absolute");
                clonedHeaderRow.css("top", "0px");
                clonedHeaderRow.css("left", $(this).css("margin-left"));
                clonedHeaderRow.css("visibility", "hidden");

                originalHeaderRow.addClass("tableFloatingHeaderOriginal");
            });
            UpdateTableHeaders();
            $(window).scroll(UpdateTableHeaders);
            $(window).resize(UpdateTableHeaders);
        });

function toggle() {
	var ele = document.getElementById("left");
	var text = document.getElementById("displayText");
	var pageContent = document.getElementById("pageContent");
	var screenwidth = screen.width;
	
	if(ele.style.display != "none") {
    		ele.style.display = "none";
			text.innerHTML = "Pokaz menu";
			if (screenwidth > 1200){
				pageContent.style.width = 1020 + 'px';
 		  		pageContent.style.left = -8 + 'px';
			} else {
				pageContent.style.width = 727 + 'px';
 		   		pageContent.style.left = -8 + 'px';
			}
			
  	}
	else {
		var text = document.getElementById("displayText");
		ele.style.display = "block";
		text.innerHTML = "Ukryj menu";
		if (screenwidth > 1200){
			pageContent.style.width = 806 + 'px';
	    pageContent.style.left = -0 + 'px';
		} else {
			pageContent.style.width = 553 + 'px';
	    pageContent.style.left = -0 + 'px';
		}
		
	}
} 

function toPDF(){
	alert('topdf');
}