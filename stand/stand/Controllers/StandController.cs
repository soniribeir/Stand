using Microsoft.AspNetCore.Mvc;

namespace Stand.Controllers
{
    public class StandController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
