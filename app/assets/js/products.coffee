$ ->
  $.get "/products", (products) ->
    $.each products, (index , product) ->
      html =
        '<div class="polaroid col-md-4 col-md-offset-2" id="cell">' +
          '<img src="/assets/images/'+product.image+'" class="splitimage" alt="Norway">' +
          '<div class="container">' +
          '<p>'+product.price+'</p>' +
          '<button type="submit" class="btn btn-default"><img src="/car" alt="Norway"></button>' +
          '</div>'+
          '</div>'
      $('#basicContainerCatalog').append html