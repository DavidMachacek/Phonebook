/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


            String.prototype.removeAccents = function () {
                return this
                        .replace(/[ě]/g, "e")
                        .replace(/[š]/g, "s")
                        .replace(/[č]/g, "c")
                        .replace(/[ř]/g, "r")
                        .replace(/[ž]/g, "z")
                        .replace(/[ý]/g, "y")
                        .replace(/[á]/g, "a")
                        .replace(/[í]/g, "i")
                        .replace(/[é]/g, "e")
                        .replace(/[úů]/g, "u");
            };

            $(document).ready(function () {
                $("#inputField").focus();

                $("#inputField").on('keyup', function () {
                    var visibleCount = 0;
                    var searchValue = $("#inputField").val().toLowerCase().removeAccents();

                    if (searchValue.substring(searchValue.length - 1, searchValue.length) === " ") {
                        searchValue = searchValue.slice(0, -1);
                    }

                    if (searchValue === "") {
                        $(".record").each(function () {
                            $(this).show();

                            visibleCount++;
                            $(this).removeClass("even odd");

                            if (visibleCount % 2 === 0) {
                                $(this).addClass("even");
                            } else {
                                $(this).addClass("odd");
                            }
                        });
                    } else {
                        var searchValues = searchValue.split(" ");

                        $(".record").each(function () {
                            var rec = $(this);
                            var toShow = false;

                            for (var i=0; i<searchValues.length; i++) {
                                if ((rec.text().toLowerCase().removeAccents().indexOf(searchValues[i])) < 0 && toShow == false) {
                                    toShow = false;
                                } else {
                                    toShow = true;
                                }
                            }

                            if (toShow) {
                                rec.show();

                                visibleCount++;
                                rec.removeClass("even odd");

                                if (visibleCount % 2 === 0) {
                                    rec.addClass("even");
                                } else {
                                    rec.addClass("odd");
                                }
                            } else {
                                rec.hide();
                            }
                        });
                    }
                    ;
                });
            });
       
