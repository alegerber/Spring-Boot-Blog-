$(document).ready(function(){
  $("#postRemove").click(function(data, status){
      var patt = /.*\?postId=(?<id>[0-9]{1,})/i;
      $.get("/post/delete?postId=" + document.location.href.match(patt)[1], function(data, status){
        document.location.pathname = "/"
        document.location.search   = ""
      });
  });
});