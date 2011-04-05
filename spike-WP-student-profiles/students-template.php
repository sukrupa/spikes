<?php get_header(); ?>

<div class="grid_18">
	<div class="inset">
		<h2 style="margin-bottom:0;">Students</h2>
	</div>	
		
	<div id="the_content">
	    <pre>
		<?php
		global $studentsContentMethod;
		$studentsContentMethod();
		?>
		</pre>
	</div>
</div>

<?php get_sidebar(); get_footer(); ?>
