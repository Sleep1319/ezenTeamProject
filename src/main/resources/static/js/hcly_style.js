//==================스크롤 업/다운===================
function scrollup() {
  window.scrollTo({ top: 0, behavior: 'smooth' });
}
function scrolldown() {
  window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });
}
document.querySelector('.up').addEventListener('click', scrollup);
document.querySelector('.down').addEventListener('click', scrolldown);
//============================================


