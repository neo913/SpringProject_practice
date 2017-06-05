<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<!--  main slide here -->
		<div id="main" class="col-md-12">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
		  		<!-- Wrapper for slides -->
		  		<div class="carousel-inner" role="listbox">
		    		<div class="item active">
		    		    <img src="resources/img/logo.jpg" alt="slide1">
		    		</div>
		    		<div class="item">
		      			<img src="resources/img/main_slide1.jpg" alt="slide2">
		      			<div class="carousel-caption">
		        			<h3>Planning to learn guitar?</h3>
		      			</div>
		    		</div>
		    		<div class="item">
		      			<img src="resources/img/main_slide2.jpg" alt="slide3">
		      			<div class="carousel-caption">
		        			<h3>Tired to play alone?</h3>
		      			</div>
		    		</div>
		    		<div class="item">
		      			<img src="resources/img/main_slide3.jpg" alt="slide3">
		      			<div class="carousel-caption">
		        			<h3>Join us today!</h3>
		      			</div>
		    		</div>
		  		</div>
			  	<!-- Left and right controls -->
		  		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		    		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    		<span class="sr-only">Previous</span>
		  		</a>
		  		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    		<span class="sr-only">Next</span>
		  		</a>
			</div>
		</div>
		
		<!-- main article -->
		<div class="col-md-8">
			<h3>The Best Community in Toronto</h3>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean enim. Etiam velit eros, auctor a, pharetra sed, rhoncus eget, neque. Fusce est sem, convallis quis, egestas eu, cursus id, metus. Aliquam eu mi eu pede tincidunt placerat. Fusce ultricies magna eu ipsum. Fusce eget turpis sit amet sem vestibulum malesuada. Sed metus augue, pellentesque a, aliquam a, auctor sit amet, lacus.</p>
		</div>
		
		<!-- main event -->
		<div class="col-md-4">
			<h3>Monthly Events</h3>
			<p>Donec lacinia ante sit amet urna. Nullam hendrerit wisi nec diam. Nullam tincidunt aliquam massa. Vestibulum at felis. Suspendisse eu elit eget turpis pellentesque posuere. Nulla consequat ipsum nec nunc.</p>
		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>