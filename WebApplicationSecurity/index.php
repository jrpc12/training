<?php   
    //CSP is a whilelist, using script-src, style-src ... are not required if you don't neeed to load external content and
    //if you have defined a default-src already, its redundan to use 'self' in others directives
    //use 'self'
    //use child-src to allow embed iframe in this page
    //connect-src allows connect to external places like an API
    //unsafe-eval && unsafe-inline
    //header("Content-Security-Policy: default-src 'self'; script-src 'self' https://code.jquery.com; style-src 'self'; img-src 'self'; font-src 'self'; object-src 'none'; media-src 'none'; child-src 'none'; connect-src 'self';");
    header("Content-Security-Policy: default-src 'self'; script-src 'self' https://code.jquery.com;");
    //X- policies are not standard, but used in many browsers
    //header("X-Frame-Options: SAMEORIGIN");
    header("X-Content-Type-Options: nosniff");  
    //--------------------------------------------
    header("Referrer-Policy: no-referrer");
    header("Feature-Policy: geolocation 'none'");
    
    
?>
<html>
    <head>
    <link rel="stylesheet" href="/css/style.css">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <h1>Web Application Security</h1>
        </header>
        <p>&nbsp;</p>
        <section>
            <img src="images/bg.jpeg" width="100%" />
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Etiam tempor orci eu lobortis elementum nibh tellus molestie. Tristique senectus et netus et malesuada fames ac turpis. Ipsum dolor sit amet consectetur adipiscing elit pellentesque. Quam viverra orci sagittis eu volutpat odio facilisis mauris sit. Ultrices vitae auctor eu augue ut lectus arcu bibendum at. Tempor nec feugiat nisl pretium fusce id velit ut. Adipiscing bibendum est ultricies integer quis auctor. Iaculis urna id volutpat lacus. Nulla pharetra diam sit amet nisl suscipit adipiscing bibendum. Consequat interdum varius sit amet mattis vulputate enim nulla. Nisi porta lorem mollis aliquam ut porttitor leo. Sed viverra ipsum nunc aliquet. Lectus proin nibh nisl condimentum. Facilisis gravida neque convallis a. Arcu dui vivamus arcu felis bibendum ut tristique. Eu scelerisque felis imperdiet proin fermentum leo vel orci.</p> 
            <p>Quis vel eros donec ac odio tempor orci dapibus. Ullamcorper morbi tincidunt ornare massa eget egestas purus viverra. Amet luctus venenatis lectus magna fringilla urna. Lorem ipsum dolor sit amet consectetur adipiscing elit duis. Etiam erat velit scelerisque in dictum. Quam quisque id diam vel quam elementum pulvinar etiam. Risus ultricies tristique nulla aliquet enim. Volutpat diam ut venenatis tellus in. In est ante in nibh mauris. Suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Magna fermentum iaculis eu non diam phasellus vestibulum lorem sed. Interdum consectetur libero id faucibus nisl tincidunt. Bibendum ut tristique et egestas quis ipsum suspendisse. Lacus suspendisse faucibus interdum posuere lorem. Tristique sollicitudin nibh sit amet commodo. Diam volutpat commodo sed egestas egestas. Bibendum est ultricies integer quis. Integer malesuada nunc vel risus commodo viverra maecenas accumsan lacus. Elementum nibh tellus molestie nunc non blandit. Enim neque volutpat ac tincidunt vitae semper.</p>
            <p>Auctor eu augue ut lectus arcu. Posuere morbi leo urna molestie at elementum eu facilisis. Lectus urna duis convallis convallis. Odio eu feugiat pretium nibh ipsum consequat nisl vel. Pellentesque id nibh tortor id aliquet lectus proin. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus et. Consequat ac felis donec et odio pellentesque. Amet purus gravida quis blandit turpis. Quis viverra nibh cras pulvinar mattis nunc sed blandit libero. Consectetur a erat nam at lectus. Sollicitudin nibh sit amet commodo nulla facilisi nullam vehicula. Commodo nulla facilisi nullam vehicula ipsum a. Sit amet commodo nulla facilisi. Dolor sit amet consectetur adipiscing elit. Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Lobortis elementum nibh tellus molestie nunc. Quam nulla porttitor massa id neque aliquam vestibulum morbi blandit. Imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada. Mattis ullamcorper velit sed ullamcorper morbi. Diam maecenas sed enim ut sem viverra aliquet.</p>
            <p>Erat imperdiet sed euismod nisi porta lorem mollis aliquam ut. Vitae proin sagittis nisl rhoncus mattis rhoncus urna neque. Ultrices tincidunt arcu non sodales neque sodales. Posuere lorem ipsum dolor sit. Sagittis aliquam malesuada bibendum arcu vitae elementum curabitur. Egestas maecenas pharetra convallis posuere morbi leo urna molestie. Consectetur adipiscing elit ut aliquam purus sit amet luctus. Sagittis vitae et leo duis ut diam. Pharetra convallis posuere morbi leo urna. Id aliquet risus feugiat in ante metus dictum at. Molestie at elementum eu facilisis sed odio morbi quis commodo. Vestibulum lorem sed risus ultricies tristique nulla. Habitant morbi tristique senectus et netus et.</p>
            <p>Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium. Purus non enim praesent elementum. Elementum tempus egestas sed sed risus pretium quam vulputate dignissim. Massa eget egestas purus viverra accumsan in nisl nisi scelerisque. Ornare lectus sit amet est placerat in. Montes nascetur ridiculus mus mauris vitae ultricies leo integer. Vel orci porta non pulvinar neque laoreet suspendisse interdum. Quis lectus nulla at volutpat diam ut venenatis tellus. Ut tellus elementum sagittis vitae et leo duis ut. Sagittis eu volutpat odio facilisis mauris. Egestas maecenas pharetra convallis posuere. Aliquet nibh praesent tristique magna sit amet purus. Elit ullamcorper dignissim cras tincidunt lobortis feugiat vivamus at augue. Venenatis urna cursus eget nunc scelerisque viverra mauris in aliquam. Sem nulla pharetra diam sit amet nisl suscipit adipiscing bibendum. Habitant morbi tristique senectus et. Vitae et leo duis ut diam quam. Aliquet lectus proin nibh nisl condimentum id venenatis a condimentum. Est sit amet facilisis magna. Egestas purus viverra accumsan in nisl nisi.</p>
            <br/><br/>
            <!-- <a href="http://register.asapconnected.com/InvoicePayment.aspx?inv=9636232&UPAY_SITE_ID=9&EXT_TRANS_ID=9636232-9358809"> Return to ASAP </a> -->
            <a href="redirect.php"> Return to ASAP </a>
        </section>        
        <footer>
        </footer>
    </body>
</html>
