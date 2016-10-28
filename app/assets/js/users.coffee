$ ->
  $.get "/users", (users) ->
    $.each users, (index , person) ->
      $('#users').append $("<li>").text user.name user.email